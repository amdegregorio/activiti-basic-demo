package com.amydegregorio.activiti.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amydegregorio.activiti.dto.EventDto;
import com.amydegregorio.activiti.dto.ProcessDefinitionDto;
import com.amydegregorio.activiti.dto.ProcessInstanceDto;
import com.amydegregorio.activiti.dto.TaskDto;
import com.amydegregorio.activiti.service.EventService;

@Controller
public class EventMonitorController {
   private static final Log LOG = LogFactory.getLog(EventMonitorController.class);
   
   @Autowired
   private EventService eventService;
   
   @Autowired
   private ProcessRuntime processRuntime;
   
   private Map<Integer, String> severities;
   
   public EventMonitorController() {
      severities = new TreeMap<>();
      severities.put(1, "URGENT");
      severities.put(2, "HIGH PRIORITY");
      severities.put(3, "MEDIUM PRIORITY");
      severities.put(4, "LOW PRIORITY");
      severities.put(5, "COMMENT ONLY");
   }
   
   @RequestMapping("/")
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String listProcessDefinitions(Model model) {
      Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
      
      List<ProcessDefinitionDto> pdDtos = processDefinitionPage.getContent().stream().map(pd -> new ProcessDefinitionDto(pd.getId(), pd.getDescription(), pd.getFormKey(), pd.getKey(), pd.getName(), pd.getVersion())).collect(Collectors.toList());
      model.addAttribute("processDefinitions", pdDtos);
      return "listProcessDefinitions";
   }
   
   @RequestMapping("/start")
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String startEntry(Model model, @RequestParam("processDefinitionId") String eventProcessDefinitionId) {
      EventDto eventDto = new EventDto();
      eventDto.setEventProcessDefinitionId(eventProcessDefinitionId);
      model.addAttribute("eventDto", eventDto);
      
      return "start";
   }
   
   @RequestMapping(value="/start",  params={"save"}, method=RequestMethod.POST)
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String saveEvent(@Valid EventDto eventDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         LOG.error("ERRORS: " + bindingResult.getErrorCount());
         bindingResult.getAllErrors().forEach(error -> LOG.error("   " + error.toString()));
         return "start";
      }
      
      LOG.info(eventDto.toString());
      eventService.logEvent(eventDto);
      
      return "redirect:/instances";
   }
   
   @RequestMapping(value="/start",  params={"cancel"}, method=RequestMethod.POST)
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String cancelEvent() {
      
      return "redirect:/";
   }
   
   @RequestMapping("/instances")
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String listProcessInstances(Model model) {
      List<ProcessInstance> processInstances = processRuntime.processInstances(Pageable.of(0, 10)).getContent();
      
      List<ProcessInstanceDto> instanceDtos = processInstances.stream().map(instance -> new ProcessInstanceDto(instance.getId(), instance.getName(), instance.getDescription(), instance.getStartDate(), instance.getInitiator(), instance.getBusinessKey(), instance.getStatus().toString(), instance.getProcessDefinitionId(), instance.getProcessDefinitionKey(), processRuntime.processInstanceMeta(instance.getId()).getActiveActivitiesIds())).collect(Collectors.toList());
      model.addAttribute("instances", instanceDtos);
      
      return "listInstances";
   }
   
   @RequestMapping("/myTasks")
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String listUsersTasks(Model model) {
      List<TaskDto> taskDtos = eventService.findUserTasks();
      
      model.addAttribute("tasks", taskDtos);
      model.addAttribute("whose", "My");
      
      return "listTasks";
   }
   
   @RequestMapping("/reviewTask")
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String reviewTask(Model model, @RequestParam("taskId") String taskId) {
      LOG.debug(String.format("In reviewTask with taskId = '%s'", taskId));
      EventDto eventDto = eventService.findTaskById(taskId);
      model.addAttribute("eventDto", eventDto);
      
      return "review";
   }
   
   @RequestMapping(value = "/completeTask", params={"save"}, method=RequestMethod.POST)
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String completeTask(@Valid EventDto eventDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         LOG.error("ERRORS: " + bindingResult.getErrorCount());
         bindingResult.getAllErrors().forEach(error -> LOG.error("   " + error.toString()));
         return "review";
      }
      eventService.completeTask(eventDto);
      
      return "redirect:/myTasks";
   }
   
   @RequestMapping(value = "/completeTask", params={"cancel"}, method=RequestMethod.POST)
   @RolesAllowed({ "ROLE_ACTIVITI_USER", "ROLE_ACTIVITI_ADMIN" })
   public String cancelReviewTask() {
            
      return "redirect:/myTasks";
   }
   
   @ModelAttribute("severities")
   public Map<Integer, String> getPriorities() {
      return severities;
   }
}

package com.amydegregorio.activiti.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.model.payloads.GetVariablesPayload;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.amydegregorio.activiti.domain.Event;
import com.amydegregorio.activiti.dto.EventDto;
import com.amydegregorio.activiti.dto.TaskDto;
import com.amydegregorio.activiti.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class EventService {
    public static final Log LOG = LogFactory.getLog(EventService.class);
    public static final String EVENT_PROCESS_KEY = "event-monitor";
   
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private ObjectMapper objectMapper;
    
    public EventDto logEvent(EventDto eventDto) {
       Event event = new Event();
       event.setDescription(eventDto.getDescription());
       event.setEventTimestamp(eventDto.getEventTimestamp());
       event.setSeverity(eventDto.getSeverity());
       
       eventRepository.save(event);
       
       Map<String, Object> eventMap = new HashMap<>();
       eventMap.put("event", event);
       eventMap.put("activeUser", getActiveUsername());
       
       ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionId(eventDto.getEventProcessDefinitionId())
                .withProcessDefinitionKey(EVENT_PROCESS_KEY)
                .withName(String.format("Event Monitor (%s - %s)", eventDto.getDescription(), Instant.now().toString()))
                .withVariables(eventMap)
                .build()
       );
       
       LOG.info("Started Process: " +processInstance.toString());
       
       eventDto.setId(event.getId());
       return eventDto;
    }
    
    public String getActiveUsername() {
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String username = "";
       if (principal instanceof UserDetails) {
         username = ((UserDetails)principal).getUsername();
       } else {
         username = principal.toString();
       }
       
       return username;
    }
    
    public EventDto completeTask(EventDto eventDto) {
       Event event = eventRepository.getOne(eventDto.getId());
       event.setComment(eventDto.getComment());
       event.setSeverity(eventDto.getSeverity());
       eventRepository.save(event);
       
       taskRuntime.complete(TaskPayloadBuilder
          .complete()
          .withTaskId(eventDto.getTaskId())
          .build()
       );
       
       return eventDto;
    }
    
    public List<TaskDto> findUserTasks() {
       Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
       
       List<TaskDto> taskDtos = tasks.getContent()
          .stream()
          .map(task -> new TaskDto(
             task.getId(), task.getOwner(), task.getAssignee(), 
             task.getName(), task.getDescription(), task.getCreatedDate(), 
             task.getClaimedDate(), task.getDueDate(), task.getPriority(),
             task.getProcessDefinitionId(), task.getProcessInstanceId(), 
             task.getParentTaskId(), task.getStatus().toString(), task.getFormKey(),
             task.getCompletedDate(), task.getDuration())).collect(Collectors.toList()
           );
       return taskDtos;
    }
    
    public EventDto findTaskById(String taskId) {
       Task task = taskRuntime.task(taskId);
       ProcessInstance instance = processRuntime.processInstance(task.getProcessInstanceId());
       List<VariableInstance> variables = processRuntime.variables(new GetVariablesPayload(task.getProcessInstanceId()));
       EventDto eventDto = new EventDto(0L, "", null, 0, instance.getProcessDefinitionId(), instance.getId(), task.getId());
       if (variables != null) {
          LOG.debug(String.format("Found %d variables", variables.size()));
          for (Iterator<VariableInstance> it = variables.iterator(); it.hasNext();) {
             VariableInstance vi = it.next();
             if (vi.getName().equals("event")) {
                ObjectNode node = vi.getValue();
                Event event = objectMapper.convertValue(node, Event.class);
                LOG.debug("Event found: " + event.toString());
                eventDto = new EventDto(event.getId(), event.getDescription(), event.getEventTimestamp(), event.getSeverity(), instance.getProcessDefinitionId(), vi.getProcessInstanceId(), task.getId());
                break;
             }
          }
       } else {
          LOG.debug("No Event found");
       }
       return eventDto;
    }
}

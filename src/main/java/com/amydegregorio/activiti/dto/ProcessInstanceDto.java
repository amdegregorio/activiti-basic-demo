package com.amydegregorio.activiti.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessInstanceDto {
   private String id;
   private String name;
   private String description;
   private Date startDate;
   private String initiator;
   private String businessKey;
   private String status;
   private String processDefinitionId;
   private String processDefinitionKey;
   private List<String> activeActivities;
   
   public ProcessInstanceDto() {
      activeActivities = new ArrayList<String>();
   }
   
   /**
    * @param id
    * @param name
    * @param description
    * @param startDate
    * @param initiator
    * @param businessKey
    * @param status
    * @param processDefinitionId
    * @param processDefinitionKey
    */
   public ProcessInstanceDto(String id, String name, String description, Date startDate, String initiator,
            String businessKey, String status, String processDefinitionId, String processDefinitionKey,
            List<String> activeActivities) { 
      super();
      this.id = id;
      this.name = name;
      this.description = description;
      this.startDate = startDate;
      this.initiator = initiator;
      this.businessKey = businessKey;
      this.status = status;
      this.processDefinitionId = processDefinitionId;
      this.processDefinitionKey = processDefinitionKey;
      this.activeActivities = activeActivities;
   }

   /**
    * Gets id.
    * @return the id
    */
   public String getId() {
      return id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(String id) {
      this.id = id;
   }
   
   /**
    * Gets name.
    * @return the name
    */
   public String getName() {
      return name;
   }
   
   /**
    * Sets name.
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * Gets description.
    * @return the description
    */
   public String getDescription() {
      return description;
   }
   
   /**
    * Sets description.
    * @param description the description to set
    */
   public void setDescription(String description) {
      this.description = description;
   }
   
   /**
    * Gets startDate.
    * @return the startDate
    */
   public Date getStartDate() {
      return startDate;
   }
   
   /**
    * Sets startDate.
    * @param startDate the startDate to set
    */
   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }
   
   /**
    * Gets initiator.
    * @return the initiator
    */
   public String getInitiator() {
      return initiator;
   }
   
   /**
    * Sets initiator.
    * @param initiator the initiator to set
    */
   public void setInitiator(String initiator) {
      this.initiator = initiator;
   }
   
   /**
    * Gets businessKey.
    * @return the businessKey
    */
   public String getBusinessKey() {
      return businessKey;
   }
   
   /**
    * Sets businessKey.
    * @param businessKey the businessKey to set
    */
   public void setBusinessKey(String businessKey) {
      this.businessKey = businessKey;
   }
   
   /**
    * Gets status.
    * @return the status
    */
   public String getStatus() {
      return status;
   }
   
   /**
    * Sets status.
    * @param status the status to set
    */
   public void setStatus(String status) {
      this.status = status;
   }
   
   /**
    * Gets processDefinitionId.
    * @return the processDefinitionId
    */
   public String getProcessDefinitionId() {
      return processDefinitionId;
   }
   
   /**
    * Sets processDefinitionId.
    * @param processDefinitionId the processDefinitionId to set
    */
   public void setProcessDefinitionId(String processDefinitionId) {
      this.processDefinitionId = processDefinitionId;
   }
   
   /**
    * Gets processDefinitionKey.
    * @return the processDefinitionKey
    */
   public String getProcessDefinitionKey() {
      return processDefinitionKey;
   }
   
   /**
    * Sets processDefinitionKey.
    * @param processDefinitionKey the processDefinitionKey to set
    */
   public void setProcessDefinitionKey(String processDefinitionKey) {
      this.processDefinitionKey = processDefinitionKey;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "ProcessInstanceDto [id=" + id + ", name=" + name + ", description=" + description + ", startDate="
               + startDate + ", initiator=" + initiator + ", businessKey=" + businessKey + ", status=" + status
               + ", processDefinitionId=" + processDefinitionId + ", processDefinitionKey=" + processDefinitionKey
               + "]";
   }

   
   /**
    * Gets activeActivities.
    * @return the activeActivities
    */
   public List<String> getActiveActivities() {
      return activeActivities;
   }

   
   /**
    * Sets activeActivities.
    * @param activeActivities the activeActivities to set
    */
   public void setActiveActivities(List<String> activeActivities) {
      this.activeActivities = activeActivities;
   }

}

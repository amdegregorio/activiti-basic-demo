package com.amydegregorio.activiti.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class EventDto {
   private Long id;
   private String description = "";
   @DateTimeFormat(pattern = "MM/dd/yy HH:mm")
   private LocalDateTime eventTimestamp;
   private int severity = 0;
   private String comment = "";
   private String eventProcessDefinitionId = "";
   private String eventProcessInstanceId = "";
   private String taskId = "";
   
   public EventDto() {
      
   }
   
   public EventDto(Long id, String description, LocalDateTime eventTimestamp, int severity,
            String eventProcessDefinitionId, String eventProcessInstanceId, String taskId) {
      super();
      this.id = id;
      this.description = description;
      this.eventTimestamp = eventTimestamp;
      this.severity = severity;
      this.eventProcessDefinitionId = eventProcessDefinitionId;
      this.eventProcessInstanceId = eventProcessInstanceId;
      this.taskId = taskId;
   }
   
   /**
    * Gets id.
    * @return the id
    */
   public Long getId() {
      return id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(Long id) {
      this.id = id;
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
    * Gets eventTimestamp.
    * @return the eventTimestamp
    */
   public LocalDateTime getEventTimestamp() {
      return eventTimestamp;
   }
   
   /**
    * Sets eventTimestamp.
    * @param eventTimestamp the eventTimestamp to set
    */
   public void setEventTimestamp(LocalDateTime eventTimestamp) {
      this.eventTimestamp = eventTimestamp;
   }
   
   /**
    * Gets severity.
    * @return the severity
    */
   public int getSeverity() {
      return severity;
   }
   
   /**
    * Sets severity.
    * @param severity the severity to set
    */
   public void setSeverity(int severity) {
      this.severity = severity;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "EventDto [id=" + id + ", description=" + description + ", eventTimestamp=" + eventTimestamp + ", severity="
               + severity + ", eventProcessDefinitionId=" + eventProcessDefinitionId + ", eventProcessInstanceId=" + eventProcessInstanceId +"]";
   }

   /**
    * Gets eventProcessDefinitionId.
    * @return the eventProcessDefinitionId
    */
   public String getEventProcessDefinitionId() {
      return eventProcessDefinitionId;
   }

   
   /**
    * Sets eventProcessDefinitionId.
    * @param eventProcessDefinitionId the eventProcessDefinitionId to set
    */
   public void setEventProcessDefinitionId(String eventProcessDefinitionId) {
      this.eventProcessDefinitionId = eventProcessDefinitionId;
   }

   
   /**
    * Gets eventProcessInstanceId.
    * @return the eventProcessInstanceId
    */
   public String getEventProcessInstanceId() {
      return eventProcessInstanceId;
   }

   
   /**
    * Sets eventProcessInstanceId.
    * @param eventProcessInstanceId the eventProcessInstanceId to set
    */
   public void setEventProcessInstanceId(String eventProcessInstanceId) {
      this.eventProcessInstanceId = eventProcessInstanceId;
   }

   
   /**
    * Gets taskId.
    * @return the taskId
    */
   public String getTaskId() {
      return taskId;
   }

   
   /**
    * Sets taskId.
    * @param taskId the taskId to set
    */
   public void setTaskId(String taskId) {
      this.taskId = taskId;
   }

   
   /**
    * Gets comment.
    * @return the comment
    */
   public String getComment() {
      return comment;
   }

   
   /**
    * Sets comment.
    * @param comment the comment to set
    */
   public void setComment(String comment) {
      this.comment = comment;
   }
}

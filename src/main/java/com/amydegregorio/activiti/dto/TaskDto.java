package com.amydegregorio.activiti.dto;

import java.util.Date;

public class TaskDto {
   private String id;
   private String owner;
   private String assignee;
   private String name;
   private String description;
   private Date createdDate;
   private Date claimedDate;
   private Date dueDate;
   private int priority;
   private String processDefinitionId;
   private String processInstanceId;
   private String parentTaskId;
   private String status;
   private String formKey;
   private Date completedDate;
   private Long duration;
   
   public TaskDto() {
      
   }
   
   public TaskDto(String id, String owner, String assignee, String name, String description, Date createdDate,
            Date claimedDate, Date dueDate, int priority, String processDefinitionId, String processInstanceId,
            String parentTaskId, String status, String formKey, Date completedDate, Long duration) {
      super();
      this.id = id;
      this.owner = owner;
      this.assignee = assignee;
      this.name = name;
      this.description = description;
      this.createdDate = createdDate;
      this.claimedDate = claimedDate;
      this.dueDate = dueDate;
      this.priority = priority;
      this.processDefinitionId = processDefinitionId;
      this.processInstanceId = processInstanceId;
      this.parentTaskId = parentTaskId;
      this.status = status;
      this.formKey = formKey;
      this.completedDate = completedDate;
      this.duration = duration;
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
    * Gets owner.
    * @return the owner
    */
   public String getOwner() {
      return owner;
   }

   
   /**
    * Sets owner.
    * @param owner the owner to set
    */
   public void setOwner(String owner) {
      this.owner = owner;
   }

   
   /**
    * Gets assignee.
    * @return the assignee
    */
   public String getAssignee() {
      return assignee;
   }

   
   /**
    * Sets assignee.
    * @param assignee the assignee to set
    */
   public void setAssignee(String assignee) {
      this.assignee = assignee;
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
    * Gets createdDate.
    * @return the createdDate
    */
   public Date getCreatedDate() {
      return createdDate;
   }

   
   /**
    * Sets createdDate.
    * @param createdDate the createdDate to set
    */
   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   
   /**
    * Gets claimedDate.
    * @return the claimedDate
    */
   public Date getClaimedDate() {
      return claimedDate;
   }

   
   /**
    * Sets claimedDate.
    * @param claimedDate the claimedDate to set
    */
   public void setClaimedDate(Date claimedDate) {
      this.claimedDate = claimedDate;
   }

   
   /**
    * Gets dueDate.
    * @return the dueDate
    */
   public Date getDueDate() {
      return dueDate;
   }

   
   /**
    * Sets dueDate.
    * @param dueDate the dueDate to set
    */
   public void setDueDate(Date dueDate) {
      this.dueDate = dueDate;
   }

   
   /**
    * Gets priority.
    * @return the priority
    */
   public int getPriority() {
      return priority;
   }

   
   /**
    * Sets priority.
    * @param priority the priority to set
    */
   public void setPriority(int priority) {
      this.priority = priority;
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
    * Gets processInstanceId.
    * @return the processInstanceId
    */
   public String getProcessInstanceId() {
      return processInstanceId;
   }

   
   /**
    * Sets processInstanceId.
    * @param processInstanceId the processInstanceId to set
    */
   public void setProcessInstanceId(String processInstanceId) {
      this.processInstanceId = processInstanceId;
   }

   
   /**
    * Gets parentTaskId.
    * @return the parentTaskId
    */
   public String getParentTaskId() {
      return parentTaskId;
   }

   
   /**
    * Sets parentTaskId.
    * @param parentTaskId the parentTaskId to set
    */
   public void setParentTaskId(String parentTaskId) {
      this.parentTaskId = parentTaskId;
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
    * Gets formKey.
    * @return the formKey
    */
   public String getFormKey() {
      return formKey;
   }

   
   /**
    * Sets formKey.
    * @param formKey the formKey to set
    */
   public void setFormKey(String formKey) {
      this.formKey = formKey;
   }

   
   /**
    * Gets completedDate.
    * @return the completedDate
    */
   public Date getCompletedDate() {
      return completedDate;
   }

   
   /**
    * Sets completedDate.
    * @param completedDate the completedDate to set
    */
   public void setCompletedDate(Date completedDate) {
      this.completedDate = completedDate;
   }

   
   /**
    * Gets duration.
    * @return the duration
    */
   public Long getDuration() {
      return duration;
   }

   
   /**
    * Sets duration.
    * @param duration the duration to set
    */
   public void setDuration(Long duration) {
      this.duration = duration;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "TaskDto [id=" + id + ", owner=" + owner + ", assignee=" + assignee + ", name=" + name + ", description="
               + description + ", createdDate=" + createdDate + ", claimedDate=" + claimedDate + ", dueDate=" + dueDate
               + ", priority=" + priority + ", processDefinitionId=" + processDefinitionId + ", processInstanceId="
               + processInstanceId + ", parentTaskId=" + parentTaskId + ", status=" + status + ", formKey=" + formKey
               + ", completedDate=" + completedDate + ", duration=" + duration + "]";
   }
   
   
}

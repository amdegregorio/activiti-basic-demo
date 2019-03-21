package com.amydegregorio.activiti.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


@Entity
public class Event implements Serializable {
   private static final long serialVersionUID = 2400917985911399656L;
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   private String description;
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime eventTimestamp;
   private int severity;
   private String comment;
   
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
      return "Event [id=" + id + ", description=" + description + ", eventTimestamp=" + eventTimestamp + ", severity="
               + severity + "]";
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

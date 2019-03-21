package com.amydegregorio.activiti.dto;

public class ProcessDefinitionDto {
   private String id;
   private String description;
   private String formKey;
   private String key;
   private String name;
   private int version;
   
   public ProcessDefinitionDto() {
      
   }
   
   public ProcessDefinitionDto(String id, String description, String formKey, String key, String name, int version) {
      this.id = id;
      this.description = description;
      this.formKey = formKey;
      this.key = key;
      this.name = name;
      this.version = version;
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
    * Gets key.
    * @return the key
    */
   public String getKey() {
      return key;
   }
   
   /**
    * Sets key.
    * @param key the key to set
    */
   public void setKey(String key) {
      this.key = key;
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
    * Gets version.
    * @return the version
    */
   public int getVersion() {
      return version;
   }
   
   /**
    * Sets version.
    * @param version the version to set
    */
   public void setVersion(int version) {
      this.version = version;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "ProcessDefinitionDto [id=" + id + ", description=" + description + ", formKey=" + formKey + ", key=" + key
               + ", name=" + name + ", version=" + version + "]";
   }
}

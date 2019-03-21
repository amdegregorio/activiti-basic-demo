package com.amydegregorio.activiti;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class JacksonConfig {

   @Bean
   @Primary
   public Jackson2ObjectMapperBuilder objectMapperBuilder() {
      Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
      builder.simpleDateFormat("MM/dd/yyyy HH:mm");
      JavaTimeModule javaTimeModule = new JavaTimeModule();
      javaTimeModule.addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
      return builder.modulesToInstall(new JavaTimeModule());
   }
}

package com.amydegregorio.activiti;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableWebSecurity
public class ActivitiApplicationConfig extends WebSecurityConfigurerAdapter {
   private static final Logger LOG = LoggerFactory.getLogger(ActivitiApplicationConfig.class);
   
   @Override
   @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(myUserDetailsService());
   }
   
   @Bean
   public UserDetailsService myUserDetailsService() {

       InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

       String[][] usersGroupsAndRoles = {
               {"user", "password", "ROLE_ACTIVITI_USER"},
               {"admin", "password", "ROLE_ACTIVITI_ADMIN"},
       };

       for (String[] user : usersGroupsAndRoles) {
           List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length));
           LOG.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings + "]");
           inMemoryUserDetailsManager.createUser(new User(user[0], passwordEncoder().encode(user[1]),
                   authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
       }

       return inMemoryUserDetailsManager;

   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
         .csrf().disable()
         .authorizeRequests()
         .anyRequest()
         .authenticated()
         .and()
         .httpBasic();
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
}

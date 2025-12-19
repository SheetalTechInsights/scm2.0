package com.scm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    //user create and login using java code with in memory service
    //create user. 
   

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User
        .withDefaultPasswordEncoder()
            .username("admin")
            .password("admin123")
            .roles("ADMIN","USER")
            .build();
  
        return new InMemoryUserDetailsManager(user1);
    

}


     
}

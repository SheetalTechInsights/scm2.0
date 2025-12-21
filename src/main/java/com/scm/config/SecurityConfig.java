package com.scm.config;




import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.scm.services.impl.SecurityCustomUserDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {


    //user create and login using java code with in memory service
    //create user. 

    // @Bean
    // public UserDetailsService userDetailsService() {

    //     UserDetails user1 = User
    //     .withDefaultPasswordEncoder()
    //         .username("admin")
    //         .password("admin123")
    //         .roles("ADMIN","USER")
    //         .build();

    //     return new InMemoryUserDetailsManager(user1);

    //}
     
    @Autowired
    private SecurityCustomUserDetailService userDetailService;
   

    @Autowired
    private OAuthAuthenticationSucessHandler handler;

    // Configuration of authentication proivder for spring security

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //user deatail service ka password
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        //password encoder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(authorize -> {

            //urls ko configure kiya h konse public rhenge or konse private
            // authorize.requestMatchers("/login", "/authenticate").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();

        });

        // httpSecurity.formLogin(Customizer.withDefaults());

        httpSecurity.formLogin(formLogin -> {
            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/authenticate");
            formLogin.successForwardUrl("/user/dashboard");
            // formLogin.failureForwardUrl("/login?error=true");

            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");
            // formLogin.failureHandler(new AuthenticationFailureHandler() {

            //     @Override
            //     public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            //             AuthenticationException exception) throws IOException, ServletException {

            //         throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationFailure'");
            //     }

            // });
        });

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.logout(logoutForm -> {
            logoutForm.logoutUrl("/do-logout");
            logoutForm.logoutSuccessUrl("/login?logout=true");
        });

        //oauth configuration

        //httpSecurity.oauth2Login(Customizer.withDefaults());
        httpSecurity.oauth2Login(oauth -> {
            oauth.loginPage("/login");
            oauth.successHandler(handler);
        });

        return httpSecurity.build();

    }

    @Bean
      public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

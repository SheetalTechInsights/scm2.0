package com.scm.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.helper.Helper;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
  
    @RequestMapping(value = "/profile")
    public String userProfile(Authentication authentication) {
       String username =  Helper.getEmailOfLoggedInUser(authentication);
       // String name = principal.getName();
        logger.info("user logged in: {}" ,username);
        return "/user/profile";
    }
}

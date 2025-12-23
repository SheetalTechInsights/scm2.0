package com.scm.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
     
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ModelAttribute
    public void addLoggedInUserInformation(Model model,Authentication authentication) {
        

    String username = Helper.getEmailOfLoggedInUser(authentication);
        System.out.println("Adding logged in information to model");
        logger.info("user logged in: {}", username);

        //data ko database se fetch krna :get user fm db

        User user = userService.getUserByEmail(username);

        System.out.println(user.getName());
        System.out.println(user.getEmail());

        model.addAttribute("loggedInUser", user);

    }

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
  
    @RequestMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {
        String username = Helper.getEmailOfLoggedInUser(authentication);
        // String name = principal.getName();
        logger.info("user logged in: {}", username);

        //data ko database se fetch krna :get user fm db

        User user = userService.getUserByEmail(username);

        System.out.println(user.getName());
        System.out.println(user.getEmail());

        model.addAttribute("loggedInUser", user);
        return "/user/profile";
    }
    


}

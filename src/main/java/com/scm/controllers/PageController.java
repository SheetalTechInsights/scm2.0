package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {

        System.out.println("home page handler");
        //sending data to view
        model.addAttribute("name", "substrings");
        model.addAttribute("youtubeChannel", "youtube");
        model.addAttribute("gitRepo", "https://github.com/SheetalTechInsights");
        return "home";
    }
  
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading..");
        return "about";
    }

    @RequestMapping("/services")
    public String servicePage() {
        System.out.println("Service page loading..");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }
    
    @GetMapping("/register")
    public String register(Model model) {
     
        
        UserForm userForm = new UserForm();

        // userForm.setName("Sheetal");
        // userForm.setAbout("this is about :Write something about yourself..");
        model.addAttribute("userForm", userForm);

        return "register";
    }

    //processing register form


   @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister( @Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult ,HttpSession session) {
      System.out.println("processing register");
     
    
      //fetch form data
     System.out.println(userForm);
     //TODO: validate form data
      if(rBindingResult.hasErrors()){
        return "register";
      }
     //save to database
    //  User user = User.builder()
    //  .name(userForm.getName())
    //  .email(userForm.getEmail())
    //  .password((userForm.getPassword()))
    //  .about(userForm.getAbout())
    //  .phoneNumber(userForm.getPhoneNumber())
    //  .profilePic("/Users/manishpatidar/Documents/College Scholarship Documents/profile.jpeg")
    //  .build();
    User user = new User();
      user.setName(userForm.getName());
      user.setEmail(userForm.getEmail());
      user.setPassword((userForm.getPassword()));
      user.setAbout(userForm.getAbout());
      user.setPhoneNumber(userForm.getPhoneNumber());
      user.setProfilePic("/Users/manishpatidar/Documents/College Scholarship Documents/profile.jpeg");
      User savedUser = userService.saveUser(user);
      System.out.println(" user saved :");

      //message registration successfull
      //add meassage
       Message message =  Message.builder().content("Registration Sucessfull").type(MessageType.green).build();

     session.setAttribute("message",message);
      //redirect to login page
    return "redirect:register";
}

}

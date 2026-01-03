package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.Contact;
import com.scm.forms.ContactForm;
import com.scm.helper.Helper;
import com.scm.services.ContactService;
import com.scm.services.UserService;
import com.scm.entities.User;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {


    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;
    
    //add contact page : handler
    @RequestMapping("/add")  
    public String addContactView(Model model) {

        ContactForm contactForm = new ContactForm();
        contactForm.setName("Sheetal Patidar");
        contactForm.setFavourite(true);
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }

    @PostMapping("/add")
    public String saveContact(@ModelAttribute ContactForm contactForm, Authentication authentication) {

        // validate form
         //TODO: add validate logic  here
        
        String username = Helper.getEmailOfLoggedInUser(authentication);
        
         

        //  form--to-->contact
      
        User user = userService.getUserByEmail(username);

        //process the contact picture

        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setFavourite(contactForm.isFavourite());
        contact.setEmail(contactForm.getEmail());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setUser(user);
        contact.setLinkdInLink(contactForm.getLinkedinLink());
        contact.setWebsiteLink(contactForm.getWebsiteLink());


        contactService.save(contact);

        System.out.println("post controller hit");
        System.out.println(contactForm);

        //set the contact picture url
        //set msg to diaplay on view
        return "redirect:/user/contacts/add";
    }
}

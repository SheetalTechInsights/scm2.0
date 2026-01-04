package com.scm.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.Contact;
import com.scm.forms.ContactForm;
import com.scm.helper.Helper;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.ContactService;
import com.scm.services.ImageService;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.scm.entities.User;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    private Logger logger = LoggerFactory.getLogger(ContactController.class);  
     
    @Autowired
    private ContactService contactService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;
    
    //add contact page : handler
    @RequestMapping("/add")  
    public String addContactView(Model model) {

        ContactForm contactForm = new ContactForm();
        // contactForm.setName("Sheetal Patidar");
        contactForm.setFavourite(true);
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }

    @PostMapping("/add")
    public String saveContact(@Valid @ModelAttribute ContactForm contactForm,BindingResult result, Authentication authentication,HttpSession session) {

        // validate form
        //Todo: added validation logic here
        if (result.hasErrors()) {

             session.setAttribute("message", Message.builder()
                .content("Please correct the following errors")
                .type(MessageType.red)
                .build());
            return "user/add_contact";
        }
        
        
        String username = Helper.getEmailOfLoggedInUser(authentication);
        
         

        //  form--to-->contact
      
        User user = userService.getUserByEmail(username);

        //process the contact picture(upload krna )

        String filename = UUID.randomUUID().toString();

       String fileURL =  imageService.uploadImage(contactForm.getContactImage(),filename);


    
        logger.info("file information: {}",contactForm.getContactImage().getOriginalFilename());

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

        contact.setPicture(fileURL);
        contactService.save(contact);

        System.out.println("post controller hit");
        System.out.println(contactForm);

        //set the contact picture url
        //set msg to diaplay on view

        session.setAttribute("message", Message.builder()
                .content("Your have successfully added a new contact")
                .type(MessageType.green)
        .
        build());
        return "redirect:/user/contacts/add";
    }
}

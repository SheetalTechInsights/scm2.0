package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {

        System.out.println("home page handler");
        //sending data to view
        model.addAttribute("name", "substrings");
        model.addAttribute("youtubeChannel", "youtube");
        model.addAttribute("gitRepo", "https://github.com/SheetalTechInsights");
        return "home";
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
    
}

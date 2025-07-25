package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;



@Controller
public class MainController {
    @GetMapping("/")
    public String index(HttpSession session,Model model) {
        model.addAttribute("id", session.getId());
        return new String("index");
    }
    
    @GetMapping("/hello")
    public String greet() {
        return new String("hello");
    }
    
    @GetMapping("/about")
    public String about() {
        return new String("about");
    }
    
}

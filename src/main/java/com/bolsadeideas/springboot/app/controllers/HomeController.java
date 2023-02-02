package com.bolsadeideas.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.models.User;

@Controller
@RequestMapping("/app")
public class HomeController {

    @GetMapping({ "", "/", "/index", "/home" })
    public String home(Model model) {
        model.addAttribute("title", "Hello, Spring Framework!");
        return "index";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        User user = new User();
        user.setNombre("Julián");
        user.setApellido("Egea");
        user.setEmail("test@email.com");

        model.addAttribute("user", user);
        model.addAttribute("title", "Profile page of: ".concat(user.getNombre()));
        return "profile";
    }
    
    @RequestMapping("/list")
    public String list(Model model) {
        List<User> usersList = new ArrayList<>();
        model.addAttribute("title", "User list: ");
        model.addAttribute("users", usersList);
        return "list";
    }


}

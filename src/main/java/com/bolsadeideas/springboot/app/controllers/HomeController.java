package com.bolsadeideas.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.models.User;

@Controller
@RequestMapping("/app")
public class HomeController {

    /**
     * 
     * @param model
     * @return /app/ , /app/index, /app/home
      */
    @GetMapping({ "", "/", "/index", "/home" })
    public String home(Model model) {
        model.addAttribute("title", "Hello, Spring Framework!");
        return "index";
    }

    /**
     * 
     * @param model
     * @return /app/profile
      */
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

    /**
     * 
     * @param model
     * @return /app/list
      */
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", "Users list ");
        return "list";
    }

    /**
     * ModelAttribute allows other views to access
     * the data returned on this method
     * (see commented table on ./templates/index.html)
     * @return A list of User
     */
    @ModelAttribute("users")
    public List<User> fillUsersList() {
        List<User> usersList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            usersList.add(
                    new User(
                            "Julián v".concat(String.valueOf(i)),
                            "Egea v".concat(String.valueOf(i)),
                            "mailv".concat(String.valueOf(i)) + "@example.com"));
        }
        return usersList;
    }

}

package com.bolsadeideas.springboot.app.controllers;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/params")
public class ParamsController {

    /**
     * 
     * @return /params/
      */
    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    /**
     * 
     * @param paramTextValue
     * @param model
     * @return /params/watch?text...
      */
    @GetMapping("/string")
    public String param(
            @RequestParam(name = "text", defaultValue = "", required = false) String paramTextValue,
            Model model) {
        model.addAttribute("result", "Param received has value: ".concat(paramTextValue));
        return "params/watch";
    }

    /**
     * 
     * @param greeting
     * @param number
     * @param model
     * @return /params/watch?greeting&number...
     */
    @GetMapping("/mix-params")
    public String param(
            @RequestParam String greeting,
            @RequestParam int number,
            Model model) {
        model.addAttribute("result", "The greeting sent is: " + greeting + ". And the number sent is: " + number);
        return "params/watch";
    }

    /**
     * 
     * @param request
     * @param model
     * @return /params/watch?greeting&number...
      */
    @GetMapping("/mix-params-servlet")
    public String param(HttpServletRequest request, Model model) {
        String greeting = request.getParameter("greeting");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        model.addAttribute("result", "The greeting sent is: " + greeting + ". And the number sent is: " + number);
        return "params/watch";
    }

}

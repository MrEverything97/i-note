package com.phuongnam.controller;

import com.phuongnam.model.ViewCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("viewCounter")

public class HomeController {
    @GetMapping("/")
    public String goHomepage(@ModelAttribute("viewCounter") ViewCounter viewCounter){
        viewCounter.increment();
        return "home";
    }
    @ModelAttribute("viewCounter")
    public ViewCounter setUpCounter() {
        return new ViewCounter();
    }

}

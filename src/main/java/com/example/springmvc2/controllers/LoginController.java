package com.example.springmvc2.controllers;

import com.example.springmvc2.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginView(Model model) {
        model.addAttribute("loginForm", new LoginForm());

        return "pages/login";
    }
}

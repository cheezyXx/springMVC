package com.example.springmvc2.controllers;

import com.example.springmvc2.forms.RegisterForm;
import com.example.springmvc2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("registerForm") RegisterForm registerForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "pages/register";
        }

        userService.create(registerForm);

        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("registerForm", new RegisterForm());

        return "pages/register";
    }
}

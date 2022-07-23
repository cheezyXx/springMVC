package com.example.springmvc2.controllers;

import com.example.springmvc2.forms.LoginForm;
import com.example.springmvc2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute("loginForm") LoginForm loginForm,
            BindingResult bindingResult
        ) {
        if (bindingResult.hasErrors()) {
            return "pages/login";
        }

        userService.login(loginForm);

        return "pages/homepage";
    }

    @GetMapping("/login")
    public String showLoginView(Model model) {
        model.addAttribute("loginForm", new LoginForm());

        return "pages/login";
    }
}

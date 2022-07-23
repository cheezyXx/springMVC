package com.example.springmvc2.service;

import com.example.springmvc2.entities.User;
import com.example.springmvc2.forms.LoginForm;
import com.example.springmvc2.forms.RegisterForm;
import com.example.springmvc2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(RegisterForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setLastName(userForm.getLastName());
        user.setFirstName(userForm.getFirstName());

        userRepository.save(user);
    }

    public void login(LoginForm loginForm) {
        // @TODO
    }
}

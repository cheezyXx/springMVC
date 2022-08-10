package com.example.springmvc2.service;

import com.example.springmvc2.entities.Role;
import com.example.springmvc2.entities.User;
import com.example.springmvc2.forms.LoginForm;
import com.example.springmvc2.forms.RegisterForm;
import com.example.springmvc2.repository.RoleRepository;
import com.example.springmvc2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserService  {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void create(RegisterForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setActive(true);
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));

        Role userRole = roleRepository.findByRole("USER_BASIC");
        user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));

        userRepository.save(user);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

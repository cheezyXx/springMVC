package com.example.springmvc2.forms;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}

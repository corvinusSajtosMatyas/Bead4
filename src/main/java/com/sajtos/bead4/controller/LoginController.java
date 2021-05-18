package com.sajtos.bead4.controller;

import com.sajtos.bead4.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userService;

    public LoginController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password) {
        return userService.login(user, password);
    }

    @PostMapping("/register")
    public String register(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        return userService.register(user, password, firstName, lastName);
    }
}
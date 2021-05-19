package com.sajtos.bead4.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sajtos.bead4.dao.entity.User;
import com.sajtos.bead4.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password,
            HttpServletResponse response) {
        String result = userService.login(user, password);
        if (result == "OK") {
            String sessionId = userService.getSessionForUser(user);
            Cookie cookie = new Cookie("session", sessionId);
            response.addCookie(cookie);
        }

        return result;
    }

    @PostMapping("/register")
    public String register(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password,
            @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
            HttpServletResponse response) {
        String result = userService.register(user, password, firstName, lastName);
        if (result == "Regisztráció megtörtént!") {
            String sessionId = userService.getSessionForUser(user);
            Cookie cookie = new Cookie("session", sessionId);
            response.addCookie(cookie);
        }
        return result;
    }

    @GetMapping("/session")
    public String readCookie(@CookieValue(value = "session") String session) {
        User userWithSession = userService.getUserForSession(session);
        if (userWithSession != null) {
            return "Üdvözlöm " + userWithSession.getUsername() + ", " + userWithSession.getLast_name() + " "
                    + userWithSession.getFirst_name() + "!";
        } else {
            return "";
        }
    }

    @PostMapping("/removeSession")
    public String removeSession(@CookieValue(value = "session") String session) {
        User userWithSession = userService.getUserForSession(session);
        return userService.removeSession(userWithSession);
    }
}
package com.sajtos.bead4.service;

import com.sajtos.bead4.dao.UserRepository;
import com.sajtos.bead4.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public void save(final User user) {
        userRepository.save(user);
    }

    public long getBooksCount() {
        return userRepository.count();
    }

    public Iterable<User> getAllBooks() {
        return userRepository.findAll();
    }

    public Optional<User> getBookById(final int userId) {
        return userRepository.findById(userId);
    }

    public String register(String userName, String password, String firstName, String lastName) {
        User user = User.builder()
                .username(userName)
                .password(password)
                .first_name(firstName)
                .last_name(lastName)
                .build();
        userRepository.save(user);
        return "Success!";
    }

    public String login(String user, String password) {
        return "OK";
    }

}

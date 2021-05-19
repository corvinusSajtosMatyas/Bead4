package com.sajtos.bead4.service;

import com.sajtos.bead4.dao.UserRepository;
import com.sajtos.bead4.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(final User user) {
        userRepository.save(user);
    }

    public long getUserCount() {
        return userRepository.count();
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(final int userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUserByUsername(final String username) {
        return userRepository.findUserByUsername(username);
    }

    public String register(String userName, String password, String firstName, String lastName) {
//        TODO:check password length
//        TODO:error handling for user id already registered

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
        List<User> userWithUsername = userRepository.findUserByUsername(user);
        if (userWithUsername.isEmpty()) {
            return "NOK";
        } else {

            return "OK";
        }
    }

}

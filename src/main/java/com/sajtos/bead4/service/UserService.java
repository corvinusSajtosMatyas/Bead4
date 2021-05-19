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

    public User getUserByUsername(final String username) {
        List<User> userWithUsername = userRepository.findUserByUsername(username);
        if (userWithUsername.isEmpty()) {
            return null;
        } else {
            return userWithUsername.get(0);
        }
    }

    public String register(String userName, String password, String firstName, String lastName) {

        User userWithUsername = getUserByUsername(userName);
        if (userWithUsername == null) {
            if (password.length() >= 8) {
                if (userName.length() >= 6) {
                    User user = User.builder().username(userName).password(password).first_name(firstName)
                            .last_name(lastName).build();
                    userRepository.save(user);
                    return "Regisztráció megtörtént!";
                } else {
                    return "A felhasználónév nem elég hosszú!";
                }
            } else {
                return "A jelszó nem elég hosszú!";
            }
        } else {
            // error handling for user id already registered
            return "A felhasználónév már használatban van!";

        }

    }

    public String login(String user, String password) {
        User userWithUsername = getUserByUsername(user);
        if (userWithUsername == null) {
            return "A felhasználó nem létzik!";
        } else {
            if (userWithUsername.getPassword().equals(password)) {
                return "OK";
            } else {
                return "A felhasználónév/jelszó nem helyes!";
            }
        }
    }

}

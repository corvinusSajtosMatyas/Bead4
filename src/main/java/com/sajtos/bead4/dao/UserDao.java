package com.sajtos.bead4.dao;

import com.sajtos.bead4.dao.entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> readAll();

    void save(User complexNumber);
}

package com.sajtos.bead4.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sajtos.bead4.dao.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findUserByUsername(String username);
    List<User> findUserBySession(String session);
}

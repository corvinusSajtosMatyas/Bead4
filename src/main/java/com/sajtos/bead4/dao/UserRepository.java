package com.sajtos.bead4.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sajtos.bead4.dao.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User save(User user);
}

package com.dev.CrudDemo2.service;

import com.dev.CrudDemo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);
}

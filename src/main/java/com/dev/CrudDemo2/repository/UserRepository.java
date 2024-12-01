package com.dev.CrudDemo2.repository;

import com.dev.CrudDemo2.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);

}

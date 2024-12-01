package com.dev.CrudDemo2.repository;

import com.dev.CrudDemo2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        User theUser = entityManager.find(User.class,id);
        return theUser;
    }

    @Override
    public User save(User user) {
        User saveUser = entityManager.merge(user);
        return saveUser;
    }

    @Override
    public void deleteById(int id) {
        User deleteUser = entityManager.find(User.class,id);
        entityManager.remove(deleteUser);
    }
}

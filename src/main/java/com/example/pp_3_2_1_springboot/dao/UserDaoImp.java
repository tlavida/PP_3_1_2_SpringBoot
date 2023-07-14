package com.example.pp_3_2_1_springboot.dao;


import com.example.pp_3_2_1_springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT user from User user", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("В базе нет пользователя с идентификатором "
                    + id);
        }
        return user;
    }

    @Override
    public void merge(User user) {
        entityManager.merge(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
}



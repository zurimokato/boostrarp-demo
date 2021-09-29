package com.zurimokato.curso.dao;

import com.zurimokato.curso.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Slf4j
public class UserDaoImp implements UserDao{
    @PersistenceContext
    EntityManager entityManger;
    @Override
    @Transactional
    public List<User> getUsers() {
        String query="FROM User";
         return entityManger.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public User getUser(Long id) {

        return entityManger.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user=entityManger.find(User.class,id);
       log.debug("object",user.toString());
        entityManger.remove(user);
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManger.persist(user);
    }
}

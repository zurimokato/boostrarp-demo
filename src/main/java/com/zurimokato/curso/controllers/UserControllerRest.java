package com.zurimokato.curso.controllers;

import com.zurimokato.curso.dao.UserDao;
import com.zurimokato.curso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControllerRest {

    @Autowired
    private UserDao userDao;
    /**
     * @return list of fruits
     */
    @RequestMapping(value="test")
    public List<String> someTest(){
        return List.of("Banana", "kiwi", "Cherry");
    }

    @RequestMapping(value = "users")
    public List<User> getUsers() {

        return userDao.getUsers();


    }




    @RequestMapping(value = "users",method = RequestMethod.DELETE)
    public  void deleteUser(@PathVariable Long id){
        userDao.delete(id);
    }


    @RequestMapping(value="users/{id}")
    public User getUser(@PathVariable Long id){

        return new User("Jhoan","Olivo",id, "noj2304@gmail.com");
    }

    @RequestMapping(value = "salute/{name}")
    public String salute(@PathVariable String name){
        return "Hello "+name;
    }
}

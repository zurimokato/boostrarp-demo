package com.zurimokato.curso.controllers;

import com.zurimokato.curso.dao.UserDao;
import com.zurimokato.curso.models.User;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllerMVC {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public String userTable(Model model){

        Iterable<User>userList=userDao.getUsers();

        model.addAttribute("users",userList);


        return "table-user";
    }

    @RequestMapping(value = "/users", method= RequestMethod.POST)
    public String registerUser(@RequestParam("name") String name, @RequestParam("lastName")String lastName,
                                          @RequestParam("phone") String phone, @RequestParam("email") String email,
                                          @RequestParam("password") String password){
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        userDao.add(user);
        return "/table-user";
    }

    @RequestMapping("/register-user")
    public String register(Model model){
        User user=new User();

        model.addAttribute("user", user);
        return "registrer-user";
    }

    @GetMapping("/d-users/{id}")
    public String deleteUser(@PathVariable Long id){
        userDao.delete(id);
        return "users";
    }

    @GetMapping("users/{id}")
    public String user(@PathVariable Long id, Model model){
        User user=userDao.getUser(id);
        model.addAttribute("user",user);
        return "user-detail";
    }

    @GetMapping("/login")
        public String login(){
        return "login";
    }

    @GetMapping("/")
    public  String init(){
        return "redirect:/login";
    }
}

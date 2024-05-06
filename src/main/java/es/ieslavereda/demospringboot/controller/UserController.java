package es.ieslavereda.demospringboot.controller;


import es.ieslavereda.demospringboot.model.User;
import es.ieslavereda.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/api/v1/users")
    public List<User> getUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/api/v1/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/api/v1/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


}












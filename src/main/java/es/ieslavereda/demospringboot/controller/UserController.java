package es.ieslavereda.demospringboot.controller;


import es.ieslavereda.demospringboot.model.User;
import es.ieslavereda.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping("/api/v1")
@RestController
public class UserController {

    private final Logger LOGGER = Logger.getLogger(getClass().getCanonicalName());


    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getUsers() {
       LOGGER.log(Level.INFO,"Obteniendo todos los usuarios");
       return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {

        LOGGER.log(Level.INFO,"Eliminando el usuario " + id);
        try{
            User user = userService.removeUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (SQLException e){
            return getResponseError(e);
        }

    }

    private ResponseEntity<?> getResponseError(SQLException e) {

        Map<String,String> map = new HashMap<>();

        map.put("errorCode",String.valueOf(e.getErrorCode()));
        map.put("message",e.getMessage());

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            User u = userService.updateUser(user);
            return new ResponseEntity<>(u, HttpStatus.OK);
        } catch (SQLException e) {
            return getResponseError(e);
        }
    }


}












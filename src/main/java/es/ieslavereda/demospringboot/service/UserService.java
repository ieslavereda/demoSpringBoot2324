package es.ieslavereda.demospringboot.service;

import es.ieslavereda.demospringboot.model.User;
import es.ieslavereda.demospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public User createUser(User user) {
        return userRepository.insertUser(user);
    }
}

package es.ieslavereda.demospringboot.repository;

import es.ieslavereda.demospringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User(1,"Juan","Garcia Lopez"));
        users.add(new User(2,"Victor","Garcia Lopez"));
        users.add(new User(3,"Tomas","Sanz Sahuquillo"));

    }

    public List<User> getAll() {
        return users;
    }

    public User findUserById(Integer id) {

        Optional<User> optional = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();

        return optional.orElse(null);

    }

    public User insertUser(User user) {
        users.add(user);
        return user;
    }
}

package es.ieslavereda.demospringboot.repository;

import es.ieslavereda.demospringboot.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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

    public User deleteUserById(Integer id) throws SQLException {

//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User user = iterator.next();
//            if (user.getId() == id) {
//                iterator.remove();
//                return user;
//            }
//        }
//        return null;

        Optional<User> optional = users.stream()
                .filter(u->u.getId() == id)
                .findFirst();

        if (optional.isPresent()) {
            users.remove(optional.get());
            return optional.get();
        }

        throw new SQLException("No existe el usuario con id " + id);

    }

    public User updateUser(User user) throws SQLException {

        User u = findUserById(user.getId());
        if(u==null) throw new SQLException("No existe el usuario con id " + user.getId());

        u.setName(user.getName());
        u.setSurname(user.getSurname());
        return u;

    }
}

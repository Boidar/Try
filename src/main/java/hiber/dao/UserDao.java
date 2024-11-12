package hiber.dao;

import hiber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    List<User> listUser();
    void deleteUser(long id);
    User saveUser(User user);
    User updateUser(User user);
    User getUserById(long id);
}

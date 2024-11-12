package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    void deleteUser(long id);
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(long id);
}

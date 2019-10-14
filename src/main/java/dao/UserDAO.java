package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void deleteUser(int userId);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

}

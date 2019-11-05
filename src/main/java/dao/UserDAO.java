package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByLoginPassword (String login, String password);

}

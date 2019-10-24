package service;

import dao.UserDAOFactory;
import model.User;

import java.io.IOException;
import java.util.List;

public interface Service {
    void addUser(User user) throws IOException;

    void deleteUser(int userId) throws IOException;

    void updateUser(User user) throws IOException;

    List<User> getAllUsers() throws IOException;

    User getUserById(int userId) throws IOException;

}

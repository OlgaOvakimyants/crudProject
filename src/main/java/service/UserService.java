package service;

import dao.UserDAOFactory;
import model.User;

import java.io.IOException;
import java.util.List;

import static dao.UserDAOFactory.createDAO;

public class UserService implements Service {

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    public void addUser(User user) throws IOException {
        createDAO().addUser(user);
    }

    public void deleteUser(int userId) throws IOException {
        User user = createDAO().getUserById(userId);
        createDAO().deleteUser(user);
    }

    public void updateUser(User user) throws IOException {
        createDAO().updateUser(user);
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = createDAO().getAllUsers();
        return users;
    }

    public User getUserById(int userId) throws IOException {
        User user = createDAO().getUserById(userId);
        return user;
    }
}

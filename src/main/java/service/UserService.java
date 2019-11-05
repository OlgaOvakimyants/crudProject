package service;

import dao.UserDAO;
import model.User;

import java.io.IOException;
import java.util.List;
import static dao.UserDAOFactory.createDAO;

public class UserService implements Service {

    private UserService(){
    }

    private static class SingletonUserService {
        private final static UserService userservice = new UserService();
    }

    public static UserService getInstance() {
        return SingletonUserService.userservice;
    }

    private static UserDAO dao;

   /* public static UserDAO getDAO() {
        if (dao == null) {
            dao = createDAO();
        }
        return dao;
    }*/

    public void addUser(User user) {
        createDAO().addUser(user);
    }

    public void deleteUser(int userId) {
        User user = getUserById(userId);
       createDAO().deleteUser(user);
    }

    public void updateUser(User user)  {
       createDAO().updateUser(user);
    }

    public List<User> getAllUsers() {
        List<User> users = createDAO().getAllUsers();
        return users;
    }

    public User getUserById(int userId)  {
        User user = createDAO().getUserById(userId);
        return user;
    }

    @Override
    public User getUserByLogin(String login, String password) throws IOException {
        User user = createDAO().getUserByLoginPassword(login, password);
        return user;
    }
}

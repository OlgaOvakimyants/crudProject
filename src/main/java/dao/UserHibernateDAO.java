package dao;

import model.User;
import model.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO (Session session) {
        this.session = session;
    }

    public void addUser(User user) throws HibernateException {
        session.save(new Users(user.getFirstName(), user.getLastName(), user.getEmail()));
    }

    public void deleteUser(int userId) throws HibernateException {
        session.delete(userId);
    }

    public void updateUser(User user) throws HibernateException {
        session.update(new Users(user.getFirstName(), user.getLastName(), user.getEmail()));
    }

    public List<User> getAllUsers() throws HibernateException {
        List<User> users = (List<User>) session.getSessionFactory().openSession().createQuery("FROM users").list();
        return users;
    }

    public User getUserById(int userId) {
        return (User) session.get(User.class, userId);
    }
}

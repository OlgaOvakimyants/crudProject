package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO (Session session) {
        this.session = session;
    }

    public void addUser(User user) throws HibernateException {
        session.save(new User(user.getFirstName(), user.getLastName(), user.getEmail()));
    }

    public void deleteUser(User user) throws HibernateException {
        session.delete(user);
    }

    public void updateUser(User user) throws HibernateException {
        session.update(new User(user.getUserID(), user.getFirstName(), user.getLastName(), user.getEmail()));
    }

    public List<User> getAllUsers() throws HibernateException {
        List<User> users = (List<User>) session.getSessionFactory().openSession().createQuery("FROM User").list();
        return users;
    }

    public User getUserById(int userId) {
        return (User) session.get(User.class, userId);
    }
}

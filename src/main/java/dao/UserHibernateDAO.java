package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO (Session session) {
        this.session = session;
    }

    public void addUser(User user) throws HibernateException {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(User user) throws HibernateException {
        Transaction transaction= session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user) throws HibernateException {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public List<User> getAllUsers() throws HibernateException {
        Transaction transaction = session.beginTransaction();
        List<User> users = (List<User>) session.getSessionFactory().openSession().createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return users;
    }

    public User getUserById(int userId) {
        return session.get(User.class, userId);
    }
}

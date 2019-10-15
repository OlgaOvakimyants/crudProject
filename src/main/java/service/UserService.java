package service;

import dao.UserHibernateDAO;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilDB.UtilHibernateDB;

import java.util.List;

public class UserService {

    private static UserService userService;
    private SessionFactory sessionFactory;

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService==null) {
            userService = new UserService(UtilHibernateDB.getSessionFactory());
        }
        return userService;
    }

    public void addUser(User user) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserHibernateDAO dao = new UserHibernateDAO(session);
        dao.addUser(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(int userId) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserHibernateDAO dao = new UserHibernateDAO(session);
        User user = dao.getUserById(userId);
        dao.deleteUser(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserHibernateDAO dao = new UserHibernateDAO(session);
        dao.updateUser(user);
        transaction.commit();
        session.close();
    }

    public List<User> getAllUsers() throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserHibernateDAO dao = new UserHibernateDAO(session);
        List<User> users = dao.getAllUsers();
        transaction.commit();
        session.close();
        return users;
    }

    public User getUserById(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserHibernateDAO dao = new UserHibernateDAO(session);
        User user = dao.getUserById(userId);
        transaction.commit();
        session.close();
        return user;
    }
}

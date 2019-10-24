package service;

import dao.UserDAOFactory;
import dao.UserHibernateDAO;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilDB.UtilHibernateDB;

import java.io.IOException;
import java.util.List;

public class UserService {

    private static UserService userService;
    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
    /*private static UserService userService;
    private SessionFactory sessionFactory;

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService==null) {
            userService = new UserService(UtilHibernateDB.getSessionFactory());
        }
        return userService;
    }*/

    public void addUser(User user) throws IOException {
    //    Session session = sessionFactory.openSession();
   //     Transaction transaction = session.beginTransaction();
       // UserHibernateDAO dao = new UserHibernateDAO(session);
      //  dao.addUser(user);
        UserDAOFactory daoFactory = new UserDAOFactory();
        daoFactory.createDAO().addUser(user);
     /*   transaction.commit();
        session.close();*/
    }

    public void deleteUser(int userId) throws IOException {
      /*  Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
       /* UserHibernateDAO dao = new UserHibernateDAO(session);
        User user = dao.getUserById(userId);
        dao.deleteUser(user);*/
       UserDAOFactory daoFactory = new UserDAOFactory();
       User user = daoFactory.createDAO().getUserById(userId);
       daoFactory.createDAO().deleteUser(user);
      /*  transaction.commit();
        session.close();*/
    }

    public void updateUser(User user) throws IOException {
      /*  Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
       /* UserHibernateDAO dao = new UserHibernateDAO(session);
        dao.updateUser(user);*/
       UserDAOFactory daoFactory = new UserDAOFactory();
       daoFactory.createDAO().updateUser(user);
      /*  transaction.commit();
        session.close();*/
    }

    public List<User> getAllUsers() throws IOException {
       /* Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
        /*UserHibernateDAO dao = new UserHibernateDAO(session);
        List<User> users = dao.getAllUsers();*/
        UserDAOFactory daoFactory = new UserDAOFactory();
        List<User> users = daoFactory.createDAO().getAllUsers();
      /*  transaction.commit();
        session.close();*/
        return users;
    }

    public User getUserById(int userId) throws IOException{
     /*   Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
      /*  UserHibernateDAO dao = new UserHibernateDAO(session);
        User user = dao.getUserById(userId);*/
      UserDAOFactory daoFactory = new UserDAOFactory();
      User user = daoFactory.createDAO().getUserById(userId);
       /* transaction.commit();
        session.close();*/
        return user;
    }
}

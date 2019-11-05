package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utilDB.DBHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class UserDAOFactory {

  /*  private static class SingletonFactory {
        private final static UserDAO dao = createDAO();
    }

    public static UserDAO getInstance() {
        return SingletonFactory.dao;
    }*/

    public static UserDAO createDAO() {
        UserDAO toReturn = null;
        try {
            Properties properties = new Properties();
            properties.load(UserDAOFactory.class.getClassLoader().getResourceAsStream("typeDAO"));
            switch (properties.getProperty("typeDAO")) {
                case "hibernate":
                    Configuration configuration = DBHelper.getConfiguration();
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
                    builder.applySettings(configuration.getProperties());
                    ServiceRegistry serviceRegistry = builder.build();
                    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                    toReturn = new UserHibernateDAO(sessionFactory.openSession());
                    break;
                case "jdbc":
                    toReturn = new UserJdbcDAO();
                    break;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
          return toReturn;
    }
}

package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utilDB.DBHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDAOFactory {


    public static UserDAO createDAO() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\User\\IdeaProjects\\crudProject\\src\\main\\resources\\typeDAO"));
        UserDAO toReturn = null;
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
          return toReturn;
    }

}

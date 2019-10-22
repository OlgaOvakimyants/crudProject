package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utilDB.DBHelper;
import utilDB.UtilHibernateDB;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class UserDAOFactory {

        public UserDAO createDAO () throws IOException {
           UserDAO toReturn = null;
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\User\\IdeaProjects\\crudProject\\src\\main\\resources\\dao"));
            String dao = properties.getProperty("typeDAO");
            if (dao.equals("hibernate")) {
                Configuration configuration = DBHelper.getConfiguration();

           //    UserHibernateDAO userHibernateDAO = new UserHibernateDAO(UtilHibernateDB.getSessionFactory().openSession());

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
                builder.applySettings(configuration.getProperties());
                ServiceRegistry serviceRegistry = builder.build();
                SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                UserHibernateDAO userHibernateDAO = new UserHibernateDAO(sessionFactory.openSession());
                toReturn = userHibernateDAO;
            }
            if (dao.equals("jdbc")) {
                UserJdbcDAO userJdbcDAO = new UserJdbcDAO();
                toReturn =  userJdbcDAO;
            }
            return toReturn;
        }

}

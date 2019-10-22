package utilDB;

import com.mysql.jdbc.Driver;


import model.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static Connection connection = null;

    private static Configuration configuration = null;

    public static Configuration getConfiguration() {
        if (configuration != null)
            return configuration;
        else {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/userdb");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "1234");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");

            return configuration;
        }
    }

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
                StringBuilder url = new StringBuilder();
                url
                        .append("jdbc:mysql://localhost:3306/userdb?")
                        .append("user=root&")
                        .append("password=1234");
                connection = DriverManager.getConnection(url.toString());
                return connection;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}

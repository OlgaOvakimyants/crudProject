package utilDB;

import com.mysql.jdbc.Driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UtilDB {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                DriverManager.registerDriver((Driver)Class.forName("com.mysql.jdbc.Driver").newInstance());
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
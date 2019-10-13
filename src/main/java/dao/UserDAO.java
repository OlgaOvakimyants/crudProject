package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import utilDB.UtilDB;

public class UserDAO {
        private Connection connection;

        public UserDAO() {
            connection = UtilDB.getConnection();
        }

        public void addUser(User user) {
            try {
                PreparedStatement preparedStatement = connection
                        .prepareStatement("insert into users(firstname,lastname,email) values (?, ?, ? )");
                // Parameters start with 1
                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteUser(int userId) {
            try {
                PreparedStatement preparedStatement = connection
                        .prepareStatement("delete from users where userID=?");
                // Parameters start with 1
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateUser(User user) {
            try {
                PreparedStatement preparedStatement = connection
                        .prepareStatement("update users set firstname=?, lastname=?, email=?" +
                                "where userID=?");
                // Parameters start with 1
                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setInt(4, user.getUserID());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<User> getAllUsers() {
            List<User> users = new ArrayList<User>();
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from users");
                while (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("userID"));
                    user.setFirstName(rs.getString("firstname"));
                    user.setLastName(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return users;
        }

        public User getUserById(int userId) {
            User user = new User();
            try {
                PreparedStatement preparedStatement = connection.
                        prepareStatement("select * from users where userID=?");
                preparedStatement.setInt(1, userId);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    user.setUserID(rs.getInt("userID"));
                    user.setFirstName(rs.getString("firstname"));
                    user.setLastName(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
        }
    }


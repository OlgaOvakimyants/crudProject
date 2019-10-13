package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListUser extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("listUser.jsp").forward(req, resp);
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();
        int userID = Integer.parseInt(req.getParameter("userID"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        dao.updateUser(new User(userID,firstName, lastName, email));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

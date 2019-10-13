package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        dao.addUser(new User(firstName, lastName, email));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

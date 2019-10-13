package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        int userID = Integer.parseInt(req.getParameter("userID"));
        dao.deleteUser(userID);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

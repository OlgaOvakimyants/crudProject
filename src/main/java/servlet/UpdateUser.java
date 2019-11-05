package servlet;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update")
public class UpdateUser extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userID = Integer.parseInt(req.getParameter("userID"));
        req.setAttribute("userID", userID);
        req.getRequestDispatcher("/user/admin/updateUser.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        int userID = Integer.parseInt(req.getParameter("userID"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (role.equals("user") | role.equals("admin")) {
            userService.updateUser(new User(userID, firstName, lastName, email, role, login, password));
            resp.sendRedirect("/admin/list");
        } else {
            req.setAttribute("userID", userID);
            req.getRequestDispatcher("/user/admin/updateUser.jsp").forward(req, resp);
        }
    }
}

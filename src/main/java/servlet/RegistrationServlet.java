package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("role") != null) {
            resp.sendRedirect("/user");
        } else {
            req.getRequestDispatcher("/authorization.jsp").forward(req, resp);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.getUserByLogin(login, password);
        if (user != null) {
            String role = user.getRole();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", role);
            if (role.equals("user")) {
                response.sendRedirect("/user");
            }
            if (role.equals("admin")) {
                response.sendRedirect("/admin/list");
            }
        } else {
            response.sendRedirect("/registration");
        }
    }

}

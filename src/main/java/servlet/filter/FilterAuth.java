package servlet.filter;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@WebFilter("/user")
public class FilterAuth implements Filter {
    UserService userService = UserService.getInstance();

    public void init(final FilterConfig filterConfig) {
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final HttpSession session = req.getSession();

        if (nonNull(session) && nonNull(session.getAttribute("role"))) {
            chain.doFilter(request, response);
        }

    }

    private void moveToPage(final HttpServletRequest req, final HttpServletResponse resp, final String role, User user) throws IOException, ServletException {
        if (role.equals("user")) {
            req.setAttribute("user", user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.getRequestDispatcher("/user.jsp").forward(req, resp);
        }
        if (role.equals("admin")) {
            List<User> users = userService.getAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/admin/list").forward(req, resp);
        }
    }

    public void destroy() {

    }

}

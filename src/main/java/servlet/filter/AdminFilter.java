package servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.util.Objects.nonNull;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    public void init(final FilterConfig filterConfig) {
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final HttpSession session = req.getSession();

        if (nonNull(session) && session.getAttribute("role").equals("admin")) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/logout");
        }
    }

    public void destroy() {
    }

}



package main.java.filter;

import main.java.entities.User;
import main.java.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/register")
public class RegisterFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        UserService userService = new UserService();

        String email = (String) servletRequest.getParameter("email");
        String password = (String) servletRequest.getParameter("password");

        User existingUser = null;

        try {
            existingUser = userService.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (existingUser.getEmail() != null) {
            // user exist, ask for another email
            String existingEmail = "User with e-mail you entered already exist.";
            request.setAttribute("existingEmail", existingEmail);
            RequestDispatcher redirectToIndexPage = request.getRequestDispatcher("view/index.jsp");
            redirectToIndexPage.forward(request, servletResponse);

        } else {
            // user does not exist
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);

            filterChain.doFilter(request, servletResponse);
        }
    }

    public void destroy() {

    }
}

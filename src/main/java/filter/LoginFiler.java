package main.java.filter;

import main.java.entities.User;
import main.java.service.UserService;
import main.java.validation.PasswordHash;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/login")
public class LoginFiler implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        UserService userService = new UserService();
        PasswordHash hash = new PasswordHash();

        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");

        User user = null;

        try {
            user = userService.getUserByEmail(email);
            if (user.getEmail() == null) {
                user = new User("", "", "", "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user.getEmail().equals(email) && user.getPassword().equals(hash.getHash(password))) {
            //right credentials
            filterChain.doFilter(request, servletResponse);

        } else {
            // wrong credentials
            String wrongCredentials = "Wrong credentials.";
            request.setAttribute("wrongCredentials", wrongCredentials);
            RequestDispatcher redirectToIndexPage = request.getRequestDispatcher("view/index.jsp");
            redirectToIndexPage.forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

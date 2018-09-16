package main.java.filter;

import main.java.entities.User;
import main.java.service.UserService;

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

        UserService userService = new UserService();

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");

        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
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

package main.java.filter;

import com.sun.deploy.net.HttpRequest;
import main.java.entities.User;
import main.java.service.UserService;
import main.java.validation.PasswordHash;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebFilter("/updatePassword")
public class UpdatePasswordFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        UserService userService = new UserService();
        PasswordHash hash = new PasswordHash();

        User user = null;
        try {
            user = (User) userService.getUserByEmail(request.getParameter("hiddenEmail"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String currentPassword = (String) request.getParameter("currentPassword");
        String newPassword = (String) request.getParameter("newPassword");

        if (user.getPassword().equals(hash.getHash(currentPassword))) {

            filterChain.doFilter(request, servletResponse);

        } else {

            User userToEdit = null;
            String hiddenEmail = request.getParameter("hiddenEmail");
            try {
                userToEdit = userService.getUserByEmail(hiddenEmail);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.setAttribute("userToEdit", userToEdit);

            String wrongConfirmPassword = "Password is NOT changed. Wrong current password field.";
            request.setAttribute("wrongConfirmPassword", wrongConfirmPassword);

            RequestDispatcher redirect = request.getRequestDispatcher("view/profilesetup.jsp");
            redirect.forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

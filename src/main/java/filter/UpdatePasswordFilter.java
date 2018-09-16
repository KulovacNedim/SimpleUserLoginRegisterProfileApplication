package main.java.filter;

import com.sun.deploy.net.HttpRequest;
import main.java.entities.User;
import main.java.service.UserService;

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

        UserService userService = new UserService();

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        User user = (User) request.getSession().getAttribute("user");

        String currentPassword = (String) request.getParameter("currentPassword");
        String newPassword = (String) request.getParameter("newPassword");

        if (user.getPassword().equals(currentPassword)) {

            filterChain.doFilter(request, servletResponse);

//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.getAddress().setStreet(street);
//            user.getAddress().setCity(city);
//
//            try {
//                userService.updateUser(user);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            request.getSession().setAttribute("user", user);
//            request.getSession().setAttribute("newPassword", newPassword);
//
//            RequestDispatcher redirectToPasswordConfirm = request.getRequestDispatcher("view/passconfirm.jsp");
//            redirectToPasswordConfirm.forward(request, servletResponse);

        } else {

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

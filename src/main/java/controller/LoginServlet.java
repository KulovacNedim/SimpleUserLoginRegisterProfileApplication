package main.java.controller;

import main.java.entities.User;
import main.java.service.AddressService;
import main.java.service.RoleService;
import main.java.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();

        String email = (String) req.getParameter("email");

        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getSession().setAttribute("user", user);

        RequestDispatcher success = req.getRequestDispatcher("view/profile.jsp");
        success.forward(req, resp);
    }
}

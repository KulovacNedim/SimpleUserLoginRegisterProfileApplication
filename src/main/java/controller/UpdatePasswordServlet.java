package main.java.controller;

import com.sun.net.httpserver.HttpServer;
import main.java.entities.User;
import main.java.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();

        User user = (User) req.getSession().getAttribute("user");

        String newPassword = (String) req.getParameter("newPassword");

        user.setPassword(newPassword);

        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String passwordChanged = "Password is changed.";
        req.setAttribute("passwordChanged", passwordChanged);

        RequestDispatcher success = req.getRequestDispatcher("view/profile.jsp");
        success.forward(req, resp);
    }
}

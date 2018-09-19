package main.java.controller;

import com.sun.net.httpserver.HttpServer;
import main.java.entities.User;
import main.java.service.UserService;
import main.java.validation.PasswordHash;

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
        if (req.getSession().getAttribute("user") == null) {
            RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
            success.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();
        PasswordHash hash = new PasswordHash();

        User user = null;
        try {
            user = (User) userService.getUserByEmail(req.getParameter("hiddenEmail"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String newPassword = (String) req.getParameter("newPassword");

        user.setPassword(hash.getHash(newPassword));

        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String passwordChanged = "Password is changed.";
        req.setAttribute("passwordChanged", passwordChanged);

        req.setAttribute("userToUpdate", user);

        RequestDispatcher success = req.getRequestDispatcher("view/profile.jsp");
        success.forward(req, resp);
    }
}

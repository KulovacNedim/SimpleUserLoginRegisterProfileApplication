package main.java.controller;

import main.java.entities.User;
import main.java.service.LogoutService;
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
import java.util.List;

@WebServlet("/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
            success.forward(req, resp);
        } else {

            UserService userService = new UserService();

            User userToDelete = null;

            if (req.getParameter("userid") == null) {
                userToDelete = (User) req.getSession().getAttribute("user");
            } else {
                try {
                    userToDelete = (User) userService.getUserById(Integer.parseInt(req.getParameter("userid")));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            req.getSession().setAttribute("userToDelete", userToDelete);

            RequestDispatcher success = req.getRequestDispatcher("view/deleteprofile.jsp");
            success.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();
        LogoutService logoutService = new LogoutService();

        User userToDelete = null;

        try {
            userToDelete = userService.getUserByEmail((String) req.getParameter("userToDelete"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userToDelete.getEmail().equals(((User) req.getSession().getAttribute("user")).getEmail())) {
            try {
                userService.deleteUser(userToDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            logoutService.logout(req);

            RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
            success.forward(req, resp);
        } else {
            try {
                userService.deleteUser(userToDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            List<User> users = null;
            try {
                users = userService.getAllUsers();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.getSession().setAttribute("users", users);

            RequestDispatcher success = req.getRequestDispatcher("view/allusers.jsp");
            success.forward(req, resp);
        }
    }
}

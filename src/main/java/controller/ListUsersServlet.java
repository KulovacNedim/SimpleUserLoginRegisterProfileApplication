package main.java.controller;

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
import java.util.List;

@WebServlet("/listusers")
public class ListUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
            success.forward(req, resp);
        } else {

            UserService userService = new UserService();

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

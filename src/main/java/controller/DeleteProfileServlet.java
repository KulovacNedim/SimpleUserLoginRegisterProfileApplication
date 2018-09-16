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

@WebServlet("/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getSession().setAttribute("user", (User) req.getSession().getAttribute("user"));

        RequestDispatcher success = req.getRequestDispatcher("view/deleteprofile.jsp");
        success.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();

        User user = (User) req.getSession().getAttribute("user");

        try {
            userService.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getSession().invalidate();

        RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
        success.forward(req, resp);
    }
}

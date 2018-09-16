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

@WebServlet("/updateInfo")
public class UpdateInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();

        User user = (User) req.getSession().getAttribute("user");

        String firstName = (String) req.getParameter("firstName");
        String lastName = (String) req.getParameter("lastName");
        String street = (String) req.getParameter("street");
        String city = (String) req.getParameter("city");

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.getAddress().setStreet(street);
        user.getAddress().setCity(city);

        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher success = req.getRequestDispatcher("view/profile.jsp");
        success.forward(req, resp);
    }
}

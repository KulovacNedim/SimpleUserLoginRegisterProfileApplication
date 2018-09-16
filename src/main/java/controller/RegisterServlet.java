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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RoleService roleService = new RoleService();
        UserService userService = new UserService();
        AddressService addressService = new AddressService();

        User user = new User();
        String email = (String) request.getSession().getAttribute("email");
        String password = (String) request.getSession().getAttribute("password");

        user.setEmail(email);
        user.setPassword(password);

        try {
            user.setRole(roleService.getRoleById(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            userService.saveUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            user.setAddress(addressService.getAddressById(userService.getUserByEmail(user.getEmail()).getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String regSucc = "You are registered. Please edit your profile.";
        request.setAttribute("regSucc", regSucc);

        request.getSession().setAttribute("user", user);

        RequestDispatcher success = request.getRequestDispatcher("view/profilesetup.jsp");
        success.forward(request, response);

    }
}

package main.java.controller;

import main.java.entities.Address;
import main.java.entities.Role;
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

@WebServlet("/updateInfo")
public class UpdateInfoServlet extends HttpServlet {

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
        RoleService roleService = new RoleService();
        AddressService addressService = new AddressService();

        User userToUpdate = null;

        try {
            userToUpdate = userService.getUserByEmail(req.getParameter("email"));
            System.out.println(userToUpdate.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userToUpdate.getEmail() == null) {
            userToUpdate = (User) req.getSession().getAttribute("user");
        } else {
            try {
                userToUpdate = (User) userService.getUserByEmail(req.getParameter("email"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String firstName = (String) req.getParameter("firstName");
        String lastName = (String) req.getParameter("lastName");
        String street = (String) req.getParameter("street");
        String city = (String) req.getParameter("city");
        Role role = null;
        Address address = null;

        try {
            role = roleService.getRoleById(Integer.parseInt(req.getParameter("roleId")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            address = addressService.getAddressById(userToUpdate.getId());
            address.setStreet(street);
            address.setCity(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        userToUpdate.setFirstName(firstName);
        userToUpdate.setLastName(lastName);
        userToUpdate.setAddress(address);
        userToUpdate.setRole(role);

        try {
            userService.updateUser(userToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userToUpdate.getEmail().equals(((User)req.getSession().getAttribute("user")).getEmail())) {
            try {
                User newUser = userService.getUserByEmail(userToUpdate.getEmail());
                req.getSession().setAttribute("user", newUser);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        req.setAttribute("userToUpdate", userToUpdate);

        RequestDispatcher success = req.getRequestDispatcher("view/profile.jsp");
        success.forward(req, resp);
    }
}

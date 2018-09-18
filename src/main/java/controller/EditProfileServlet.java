package main.java.controller;

import main.java.entities.Role;
import main.java.entities.User;
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
import java.util.List;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
            success.forward(req, resp);
        } else {
            UserService userService = new UserService();
            RoleService roleService = new RoleService();

            User userToEdit = null;

            if (req.getParameter("userid") == null) {
                userToEdit = (User) req.getSession().getAttribute("user");
            } else {

                try {
                    userToEdit = (User) userService.getUserById(Integer.parseInt(req.getParameter("userid")));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            List<Role> roles = null;
            try {
                roles = roleService.getAllRoles();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.setAttribute("roles", roles);
            req.getSession().setAttribute("userToEdit", userToEdit);

            RequestDispatcher success = req.getRequestDispatcher("view/profilesetup.jsp");
            success.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

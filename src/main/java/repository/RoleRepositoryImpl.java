package main.java.repository;

import main.java.dbConnectionMenager.ConnectionMenager;
import main.java.entities.Role;
import main.java.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {

    private Connection connection = ConnectionMenager.getConnectionToDatabase();

    @Override
    public Role getRoleById(int roleId) throws SQLException {

        Role role = null;

        String query = "SELECT * FROM roles WHERE id = ?";

        ResultSet rs = null;

        try (PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setInt(1, roleId);

            rs = statement.executeQuery();

            if (rs.next()) {

                role = new Role(rs.getInt("id"), rs.getString("role_name"));

                rs.close();
            }

            return role;
        }





    }

    @Override
    public List<Role> getAllRoles() throws SQLException {

        List<Role> roles = new ArrayList<>();

        String query = "SELECT * FROM roles";

        ResultSet rs = null;

        try (Statement statement = connection.createStatement();) {

            rs = statement.executeQuery(query);

            while (rs.next()) {
                Role role = getRoleById(rs.getInt("id"));
                roles.add(role);
            }
        }

        return roles;

    }


}

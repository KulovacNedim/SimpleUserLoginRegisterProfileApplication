package main.java.repository;

import main.java.dbConnectionMenager.ConnectionMenager;
import main.java.entities.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


}

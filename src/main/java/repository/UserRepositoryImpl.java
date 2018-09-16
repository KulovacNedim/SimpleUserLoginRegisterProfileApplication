package main.java.repository;

import main.java.dbConnectionMenager.ConnectionMenager;
import main.java.entities.Address;
import main.java.entities.User;
import main.java.service.AddressService;
import main.java.service.RoleService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    private Connection connection = ConnectionMenager.getConnectionToDatabase();
    private AddressService addressService= new AddressService();
    private RoleService roleService = new RoleService();

    public void saveUser(User user) throws SQLException {

        String query = "INSERT INTO users(first_name, last_name, email, password, role_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRole().getId());

            statement.executeUpdate();
        }

        // save empty address for user (one-to-one relation)
        Address address = new Address();
        address.setId(getUserByEmail(user.getEmail()).getId());
        addressService.saveAddress(address);
    }

    public User getUserByEmail(String email) throws SQLException {

        User user = new User();

        String query = "SELECT * FROM users WHERE email = ?";

        ResultSet rs = null;

        try (PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setString(1, email);

            rs = statement.executeQuery();

            if (rs.next()) {

                user = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("password"),
                        addressService.getAddressById(rs.getInt("id")), roleService.getRoleById(rs.getInt("role_id")));

                rs.close();
            }
        }

        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {

        String query = "UPDATE users SET first_name = ?, last_name = ?, password = ? WHERE email = ?";

        try (
                PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());

            statement.executeUpdate();

            addressService.updateAddress(getUserByEmail(user.getEmail()).getId(), user.getAddress().getStreet(),
                    user.getAddress().getCity());
        }
    }
}

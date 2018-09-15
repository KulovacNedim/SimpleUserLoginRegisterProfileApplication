package main.java.repository;

import main.java.dbConnectionMenager.ConnectionMenager;
import main.java.entities.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRepositoryImpl implements AddressRepository {

    private Connection connection = ConnectionMenager.getConnectionToDatabase();

    @Override
    public Address getAddressById(int addressId) throws SQLException {

        Address address = null;

        String query = "SELECT * FROM addresses WHERE id = ?";

        ResultSet rs = null;

        try (PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setInt(1, addressId);

            rs = statement.executeQuery();

            if (rs.next()) {

                address = new Address(rs.getInt("id"), rs.getString("street"), rs.getString("city"));

                rs.close();
            }
        }

        return address;
    }

    @Override
    public void saveAddress(Address address) throws SQLException {

        String query = "INSERT INTO addresses(id, street, city) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setInt(1, address.getId());
            statement.setString(2, address.getStreet());
            statement.setString(3, address.getCity());

            statement.executeUpdate();
        }

    }
}

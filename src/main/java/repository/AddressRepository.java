package main.java.repository;

import main.java.entities.Address;

import java.sql.SQLException;

public interface AddressRepository {

    public Address getAddressById(int addressId) throws SQLException;

    public void saveAddress(Address address) throws SQLException;

    public void updateAddress(int address_id, String street, String city) throws SQLException;
}

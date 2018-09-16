package main.java.service;

import main.java.entities.Address;
import main.java.repository.AddressRepository;
import main.java.repository.AddressRepositoryImpl;

import java.sql.SQLException;

public class AddressService {

    private AddressRepositoryImpl addressRepo = new AddressRepositoryImpl();

    public Address getAddressById(int addressId) throws SQLException {
        return addressRepo.getAddressById(addressId);
    }

    public void saveAddress(Address address) throws SQLException {
        addressRepo.saveAddress(address);
    }

    public void updateAddress(int address_id, String street, String city) throws SQLException {
        addressRepo.updateAddress(address_id, street, city);
    }

    public void deleteAddressById(int address_id) throws SQLException {
        addressRepo.deleteAddressById(address_id);
    }
}

package main.java.repository;

import main.java.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    public void saveUser(User user) throws SQLException;

    public User getUserByEmail(String email) throws SQLException;

    public User getUserById(int id) throws SQLException;

    public void updateUser(User user) throws SQLException;

    public void deleteUser(User user) throws SQLException;

    public List<User> getAllUsers() throws SQLException;
}

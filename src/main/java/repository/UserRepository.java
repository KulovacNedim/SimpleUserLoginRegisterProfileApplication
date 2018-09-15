package main.java.repository;

import main.java.entities.User;

import java.sql.SQLException;

public interface UserRepository {

    public void saveUser(User user) throws SQLException;

    public User getUserByEmail(String email) throws SQLException;
}

package main.java.service;

import main.java.entities.User;
import main.java.repository.UserRepositoryImpl;

import java.sql.SQLException;

public class UserService {

    private UserRepositoryImpl userRepo = new UserRepositoryImpl();

    public User getUserByEmail(String email) throws SQLException {
        return userRepo.getUserByEmail(email);
    }

    public void saveUser(User user) throws SQLException {
        userRepo.saveUser(user);
    }

    public void updateUser (User user) throws SQLException {
        userRepo.updateUser(user);
    }
}
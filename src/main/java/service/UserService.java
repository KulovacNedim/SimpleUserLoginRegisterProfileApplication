package main.java.service;

import main.java.entities.User;
import main.java.repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserRepositoryImpl userRepo = new UserRepositoryImpl();

    public User getUserByEmail(String email) throws SQLException {
        return userRepo.getUserByEmail(email);
    }

    public User getUserById(int userId) throws SQLException {
        return userRepo.getUserById(userId);
    }

    public void saveUser(User user) throws SQLException {
        userRepo.saveUser(user);
    }

    public void updateUser(User user) throws SQLException {
        userRepo.updateUser(user);
    }

    public void deleteUser (User user) throws SQLException {
        userRepo.deleteUser(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepo.getAllUsers();
    }
}
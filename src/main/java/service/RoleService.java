package main.java.service;

import main.java.entities.Role;
import main.java.repository.RoleRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class RoleService {

    private RoleRepositoryImpl roleRepo = new RoleRepositoryImpl();

    public Role getRoleById(int roleId) throws SQLException {
        return roleRepo.getRoleById(roleId);
    }

    public List<Role> getAllRoles() throws SQLException {
        return roleRepo.getAllRoles();
    }
}

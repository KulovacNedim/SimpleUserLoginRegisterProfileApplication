package main.java.repository;

import main.java.entities.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleRepository {

    public Role getRoleById(int roleId) throws SQLException;

    public List<Role> getAllRoles() throws SQLException;
}

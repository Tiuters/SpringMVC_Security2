package jm.security.service;

import jm.security.model.Role;

public interface RoleService {
    Role getRoleByName(String roleName);
    void saveRole(Role role);
}

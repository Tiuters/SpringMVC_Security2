package jm.security.service;

import jm.security.dao.RoleDao;
import jm.security.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService{
    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}

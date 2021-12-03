package jm.security.defaultUsers;

import jm.security.dao.RoleDao;
import jm.security.dao.UserDao;
import jm.security.model.Role;
import jm.security.model.User;
import jm.security.service.RoleService;
import jm.security.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

//@Component
public class StartUpUsers {
//    private final UserDao userDao;
//    private final RoleDao roleDao;
//
//    public StartUpUsers(UserDao userDao, RoleDao roleDao) {
//        this.userDao = userDao;
//        this.roleDao = roleDao;
//    }

//    @PostConstruct
//    public void createStartUpUsers() {
//
//        User admin = new User("Bob", "Sec", "Hhh",
//            "admin", "000");
//        Role adminRole = new Role("ROLE_ADMIN");
//
//        userDao.newUser(admin);
//        roleDao.saveRole(adminRole);
//        admin.addRoleToUser(adminRole);
//        adminRole.addUserToRole(admin);
//    }
}
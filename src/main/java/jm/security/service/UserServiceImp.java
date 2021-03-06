package jm.security.service;

import jm.security.dao.UserDao;
import jm.security.dao.RoleDao;
import jm.security.model.Role;
import jm.security.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final RoleService roleService;

    public UserServiceImp(UserDao userDao, RoleDao roleDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.roleService = roleService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Override
    @Transactional
    public void newUser(User user) {
        userDao.newUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByName(String username) {
        return userDao.getUserByUsername(username);
    }

//    private final Map<String, User> userMap = Collections.singletonMap("test",
//        new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
//    @Override
//    public User getUserByName(String name) {
//        if (!userMap.containsKey(name)) {
//            return null;
//        }
//        return userMap.get(name);
//    }

    @Override
    public void createStartUpUsers() {

        User admin = new User("Bob", "Sec", "god",
            "admin", "111");
        User user = new User("Chin", "Drake", "puser",
            "user", "222");

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        newUser(admin);
        roleService.saveRole(roleAdmin);
        admin.addRoleToUser(roleAdmin);

        userDao.newUser(user);
        roleDao.saveRole(roleUser);
        user.addRoleToUser(roleUser);
    }
}
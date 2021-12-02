package jm.security.service;

import jm.security.dao.UserDao;
import jm.security.dao.RoleDao;
import jm.security.model.Role;
import jm.security.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserServiceImp(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
//    @Transactional(readOnly = true)
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Override
    public void newUser(User user) {

        userDao.newUser(user);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByName(String username){
        return userDao.getUserByUsername(username);
    }

//    private final Map<String, User> userMap = Collections.singletonMap("test",
//        new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
//    @Override
//    public User getUserByName(String name) {
//        if (!userMap.containsKey(name)) {
//            return null;
//        }
//
//        return userMap.get(name);
//    }




    @Override
    public void createStartUpUsers() {
        User admin = new User("Bob", "Sec", "Hhh",
            "admin", "000");
        Role adminRole = new Role("ROLE_ADMIN");

        newUser(admin);
        roleDao.saveRole(adminRole);
        admin.addRoleToUser(adminRole);
        adminRole.addUserToRole(admin);

    }
}
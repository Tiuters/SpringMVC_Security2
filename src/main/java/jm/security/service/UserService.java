package jm.security.service;

import jm.security.model.Role;
import jm.security.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> showAllUsers();
    User showUser(Long id);
    void newUser(User user);
    void editUser(User user);
    void deleteUser(Long id);
    User getUserByName(String username);
    void createStartUpUsers();

}

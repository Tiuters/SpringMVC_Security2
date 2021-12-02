package jm.security.dao;

import jm.security.model.User;
import java.util.List;

public interface UserDao {
   List<User> showAllUsers();
   User showUser(Long id);
   void newUser(User user);
   void editUser(User user);
   void deleteUser(Long id);
   User getUserByUsername(String username);
}

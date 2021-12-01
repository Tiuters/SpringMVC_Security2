package jm.security.dao;

import jm.security.model.User;

public interface UserDao {
    User getUserByName(String name);
}

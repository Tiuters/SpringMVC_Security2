package jm.security.defaultUsers;

import jm.security.service.UserService;

import javax.annotation.PostConstruct;

public class StartUpUsers {
    private UserService userService;

    public StartUpUsers(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.createStartUpUsers();
    }
}

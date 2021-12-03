package jm.security.controllers;

import jm.security.defaultUsers.StartUpUsers;
import jm.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final StartUpUsers startUpUsers;

    public UserController(UserService userService, StartUpUsers startUpUsers) {
        this.userService = userService;
        this.startUpUsers = startUpUsers;
    }

    @GetMapping(value = "")
    public String getUserPage() {
        return "user";
    }

//    @GetMapping(value = "/")
//    public String getHomePage() {
//        return "index";
//    }

//    @GetMapping(value = "/login")
//    public String getLoginPage() {
//        return "login";
//    }



//    @GetMapping(value = "/admin")
//    public String getAdminPage() {
//        return "admin";
//    }

    @PostConstruct
    public void defaultUsers() {
        userService.createStartUpUsers();
    }
}

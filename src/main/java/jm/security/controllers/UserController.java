package jm.security.controllers;

import jm.security.defaultUsers.StartUpUsers;
import jm.security.service.UserService;
import jm.security.serviceSecurity.UserDetailsServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final StartUpUsers startUpUsers;
    private UserDetailsServiceImpl userDetailsService;

    public UserController(UserService userService, StartUpUsers startUpUsers) {
        this.userService = userService;
        this.startUpUsers = startUpUsers;
    }

    @GetMapping(value = "")
    public String UserButton() {
        return "/user_button";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        model.addAttribute("user", userService.showUser(id).getRoles());
        return "user";
    }

//    @GetMapping(value = "/details")
//    public String getUserPage(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", userDetailsService.loadUserByUsername(authentication.getName()));
//        return "user";
//    }

//    @GetMapping("/give_me_them_all")
//    public String showAllUsers(Model model) {
//        model.addAttribute("users", userService.showAllUsers());
//        return "/all_users_fall_in";
//    }

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

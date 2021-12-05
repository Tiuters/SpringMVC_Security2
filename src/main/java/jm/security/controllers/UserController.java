package jm.security.controllers;

import jm.security.defaultUsers.StartUpUsers;
import jm.security.model.User;
import jm.security.service.UserService;
import jm.security.serviceSecurity.UserDetailsServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String show(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "user";
    }

    @PostConstruct
    public void defaultUsers() {
        userService.createStartUpUsers();
    }
}




//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        User principal = (User) authentication.getPrincipal();


package jm.security.controllers;

import jm.security.model.User;
import jm.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/give_me_them_all")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "/all_users_fall_in";
    }

    @GetMapping("/get_user_to_edit/{id}")
    public String userToBeEdited(@PathVariable("id") Long id, Model model) {
        User user = userService.showUser(id);
        model.addAttribute("user", user);
        return "/edit_this_user";
    }

    @PutMapping ("/updated_user")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/all_users_fall_in";
    }

    @GetMapping("/make_new_empty")
    public String emptyUser(@ModelAttribute("user") User user) {
        return "/empty_to_fill_in";
    }

    @PostMapping("/brand_new_user")
    public String newUser(User user) {
        userService.newUser(user);
        return "redirect:/users";
    }
}

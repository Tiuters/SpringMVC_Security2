package jm.security.controllers;

import jm.security.model.Role;
import jm.security.model.User;
import jm.security.service.RoleService;
import jm.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
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

    @PutMapping("/updated_user")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "checkBox", required = false) String[] checkBox) {
        if (checkBox == null) {
            return "/empty_checkboxes";
        }
        Set<Role> set = new HashSet<>();
        for (String role : checkBox) {
            set.add(roleService.getRoleByName(role));
        }
        user.setRoles(set);
        userService.editUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/make_new_empty")
    public String emptyUser(@ModelAttribute("user") User user) {
        return "/empty_to_fill_in";
    }

    @PostMapping("/brand_new_user")
    public String newUser(@ModelAttribute("user") User user,
                          @RequestParam(value = "checkBox", required = false) String[] checkBox) {
        if (checkBox == null) {
            return "/empty_checkboxes";
        }
        Set<Role> set2 = new HashSet<>();
        for (String role : checkBox) {
            set2.add(roleService.getRoleByName(role));
        }
        user.setRoles(set2);

        userService.newUser(user);
        return "redirect:/admin";
    }
}

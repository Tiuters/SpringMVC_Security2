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
//        Set<Role> setRoles = user.getRoles();
//        List<String> listRoles = userService.rolesToList(setRoles);
        model.addAttribute("user", user);
//        model.addAttribute("listRoles", listRoles);
        return "/edit_this_user";
    }

    @PutMapping("/updated_user")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam("checkBox") String[] checkBox) {
        Set<Role> set = new HashSet<>();
        for (String role : checkBox) {
            set.add(roleService.getRoleByName(role));
        }
        user.setRoles(set);
        userService.editUser(user);
        return "redirect:/admin/give_me_them_all";
    }

    @DeleteMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/give_me_them_all";
    }

    @GetMapping("/make_new_empty")
    public String emptyUser(@ModelAttribute("user") User user) {
        return "/empty_to_fill_in";
    }

    @PostMapping("/brand_new_user")
    public String newUser(@ModelAttribute("user") User user,
                          @RequestParam("checkBox") String[] checkBox) {

        Set<Role> set2 = new HashSet<>();
        for (String role : checkBox) {
            set2.add(roleService.getRoleByName(role));
        }
        user.setRoles(set2);
        userService.newUser(user);
        return "redirect:/admin/give_me_them_all";
    }

//    @PostMapping("/brand_new_user")
//    public String newUser(User user) {
//        userService.newUser(user);
//        return "redirect:/admin/give_me_them_all";
//    }
}

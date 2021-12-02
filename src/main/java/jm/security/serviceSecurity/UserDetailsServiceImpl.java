package jm.security.serviceSecurity;

import jm.security.dao.UserDao;
import jm.security.model.Role;
import jm.security.model.User;
import jm.security.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDetails = userService.getUserByName(username);
        return userDetails;
    }

//        User user = userDao.getUserByUsername(username);
//        if(user == null) {
//            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
//        }
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//        for (Role role : user.getRoles()) {
//            System.out.println(role.toString());
//        }
//        return new org.springframework.security.core.userdetails.User(
//            user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
////            user.getUsername(), user.getPassword(), user.getRoles());
//    }
//
//    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
//    }
}

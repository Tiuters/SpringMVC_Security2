package jm.security.model;

//*************************MY USER**************************************************************
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "post")
    private String post;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String lastName, String post, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.post = post;
        this.username = username;
        this.password = password;
    }

//    public User(Long id, String username, String password, Set<Role> roles) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }

    public void addRoleToUser(Role role) {
        if (roles == null) {
            roles = new HashSet<>();
        }
        roles.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getRolesAsString() {
StringBuilder sb = new StringBuilder();
        for (Role role : roles) {
            sb.append(role.getRole().toString()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(post, user.post) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, post, username, password);
    }
}

//*************************************************************************************************************

// Для того, чтобы в дальнейшим использовать класс User в Spring Security, он должен реализовывать интерфейс UserDetails.
// UserDetails можно представить, как адаптер между БД пользователей и тем что требуется Spring Security внутри SecurityContextHolder
//public class User implements UserDetails {
//    private Long id;
//    private String name; // уникальное значение
//    private String password;
//    private Set<Role> roles;
//
//    public User() {
//
//    }
//
//    public User(Long id, String name, String password, Set<Role> roles) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.roles = roles;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return name;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//}

//*****************************FISUNOV*****************************************
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//@Data
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//
//    private String password;
//
//    private String email;
//
//    @ManyToMany
//    @JoinTable(name = "users_roles",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Collection<Role> roles;
//}



//************************************************************************************

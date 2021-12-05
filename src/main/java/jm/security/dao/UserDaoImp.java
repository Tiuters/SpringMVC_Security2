package jm.security.dao;

import jm.security.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        return entityManager.createQuery(
            "FROM User", User.class).getResultList();
    }

    @Override
    public User showUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void newUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {entityManager.remove(showUser(id));
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager
            .createQuery("SELECT u FROM User AS u WHERE u.username = : username", User.class)
            .setParameter("username", username)
            .getSingleResult();
    }

//    @Override
//    public User getUserByUsername(String username) {
//        TypedQuery<User> query = entityManager.createQuery(
//            "SELECT u FROM User u WHERE u.username = :username", User.class);
//        query.setParameter("username", username);
//        User singleResult = query.getSingleResult();
//        return singleResult;
//    }
}


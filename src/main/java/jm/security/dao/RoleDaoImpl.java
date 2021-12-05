package jm.security.dao;

import jm.security.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return entityManager
            .createQuery("SELECT r FROM Role AS r WHERE r.role = : roleName", Role.class)
            .setParameter("roleName", roleName)
            .getSingleResult();
    }
}

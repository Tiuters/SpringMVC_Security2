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
}

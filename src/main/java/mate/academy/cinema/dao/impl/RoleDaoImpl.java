package mate.academy.cinema.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mate.academy.cinema.dao.RoleDao;
import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add a Role entity", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Role> query = criteriaBuilder.createQuery(Role.class);
            Root<Role> root = query.from(Role.class);
            query.select(root).where(criteriaBuilder.equal(root.get("roleName"),
                    Role.RoleName.valueOf(roleName)));
            return session.createQuery(query).uniqueResult();
        } catch (Exception exception) {
            throw new DataProcessingException("Error getting a role", exception);
        }
    }
}

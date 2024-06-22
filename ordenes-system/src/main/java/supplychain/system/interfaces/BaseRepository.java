package supplychain.system.interfaces;

import supplychain.system.utils.constantes.EstadoRegistro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dovelasquez
 * @param <T>
 * @param <ID>
 */
public class BaseRepository<T, ID extends Serializable> {

    private final EntityManagerFactory entityManagerFactory;
    private final Class<T> entityClass;

    public BaseRepository(EntityManagerFactory entityManagerFactory, Class<T> entityClass) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityClass = entityClass;
    }

    public Optional<T> findById(ID id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T result = entityManager.find(entityClass, id);
        return Optional.ofNullable(result);
    }

    public List<T> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public List<T> findAll(Integer pageNumber, Integer pageSize) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        cq.select(root);

        TypedQuery<T> query = entityManager.createQuery(cq);
        if (pageNumber != null && pageSize != null) {
            query.setFirstResult(pageNumber * pageSize);
            query.setMaxResults(pageSize);
        }
        return query.getResultList();

    }

    public Optional<T> findFirstByField(String fieldName, String value) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root).where(cb.equal(root.get(fieldName), value));
        try {
            return Optional.ofNullable(entityManager.createQuery(query).getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (NonUniqueResultException e) {
            List<T> result = entityManager.createQuery(query).getResultList();
            return result.stream().findFirst();
        }
    }

    public List<T> findAllByField(String fieldName, String value) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root).where(cb.equal(root.get(fieldName), value));
        List<T> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    public List<T> findAllByField(String fieldName, Object value) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root).where(cb.equal(root.get(fieldName), value));
        List<T> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    public List<T> findAllByFieldIn(String fieldName, List<?> values) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root).where(root.get(fieldName).in(values));
        List<T> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    public T save(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public void delete(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public T update(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            T updatedEntity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return updatedEntity;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

}

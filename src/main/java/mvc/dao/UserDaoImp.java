package mvc.dao;

import mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private  EntityManagerFactory entityManagerFactory;
    @Autowired
    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<User> index() {
        List<User> users = entityManagerFactory.createEntityManager().createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public User read(int id) {
        return entityManagerFactory.createEntityManager().find(User.class, id);
    }

    @Override
    public void create(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void update(int id, User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        user.setId(id);
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.flush();
    }
}

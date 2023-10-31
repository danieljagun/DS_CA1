package dao;

import com.bank.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("danielPU");

    public UserDAO() {

    }

    public void persistUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void removeUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(user));
        em.getTransaction().commit();
        em.close();
    }

    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<User> users = new ArrayList<User>();
        users = em.createQuery("from User").getResultList();
        em.getTransaction().commit();
        em.close();
        return users;
    }

}

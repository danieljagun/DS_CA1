package dao;

import com.bank.model.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("danielPU");

    public LoanDAO() {

    }

    public void persistLoan(Loan loan){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(loan);
        em.getTransaction().commit();
        em.close();
    }

    public void removeLoan(Loan loan){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(loan));
        em.getTransaction().commit();
        em.close();
    }

    public List<Loan> getAllLoans() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Loan> loans = new ArrayList<>();
        loans = em.createQuery("from Loan").getResultList();
        em.getTransaction().commit();
        em.close();
        return loans;
    }
}

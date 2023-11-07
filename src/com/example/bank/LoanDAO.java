package com.example.bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.bank.model.Loan;

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

    public Loan getLoanByLoanId(String loanId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Loan loan = em.createQuery("SELECT l FROM Loan l WHERE l.loanId = :loanId", Loan.class)
                .setParameter("loanId", loanId)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return loan;
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

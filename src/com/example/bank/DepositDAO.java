package com.example.bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.bank.model.Deposit;

import java.util.ArrayList;
import java.util.List;

public class DepositDAO {

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("danielPU");

    public DepositDAO() {

    }

    public void persistDeposit(Deposit deposit) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(deposit);
        em.getTransaction().commit();
        em.close();
    }

    public void removeDeposit(Deposit deposit) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(deposit));
        em.getTransaction().commit();
        em.close();
    }

    public Deposit getDepositByDepId(String depId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Deposit deposit = em.createQuery("SELECT d FROM Deposit d WHERE d.depId = :depId", Deposit.class)
                .setParameter("depId", depId)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return deposit;
    }


    public List<Deposit> getAllDeposits() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Deposit> deposits = new ArrayList<>();
        deposits = em.createQuery("from Deposit").getResultList();
        em.getTransaction().commit();
        em.close();
        return deposits;
    }
}
package com.bank.model;

import javax.persistence.*;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String depositDate;
    private double depositAmount;

    @ManyToOne
    private User user;


    public Deposit() {

    }

    public Deposit(String depositDate, double depositAmount, User user) {
        this.depositDate = depositDate;
        this.depositAmount = depositAmount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

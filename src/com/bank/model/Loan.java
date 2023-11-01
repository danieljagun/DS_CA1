package com.bank.model;

import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String description;
    private double loanAmount;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Loan() {

    }

    public Loan(String description, double loanAmount, User user) {
        this.description = description;
        this.loanAmount = loanAmount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.example.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String loanId;
    private String description;
    private double loanAmount;

    @OneToOne
    private User user;

    public Loan() {

    }

    public Loan(String loanId, String description, double loanAmount) {
        this.loanId = loanId;
        this.description = description;
        this.loanAmount = loanAmount;
    }


    public String getLoanId() {
        return this.loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
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

}

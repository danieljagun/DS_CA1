package com.example.bank.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "deposit"

)
@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int id;
    private String depId;
    private String depositDate;
    private double depositAmount;

    public Deposit() {

    }

    public Deposit(String depId, String depositDate, double depositAmount) {
        this.depId = depId;
        this.depositDate = depositDate;
        this.depositAmount = depositAmount;
    }

    @XmlElement
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @XmlElement
    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    @XmlElement
    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }
}

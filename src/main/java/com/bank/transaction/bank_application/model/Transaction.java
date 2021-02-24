package com.bank.transaction.bank_application.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Account account;
    private double amount;
    private String action;
    private String status;
    private LocalDate date = LocalDate.now();

    public Transaction() {
    }

    public Transaction(Account account, double amount, String action) {
        this.account = account;
        this.amount = amount;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateTime() {
        return date;
    }

    public void setDateTime(LocalDate dateTime) {
        this.date = dateTime;
    }
}

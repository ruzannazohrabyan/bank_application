package com.bank.transaction.bank_application.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double balance;

    @Column(name = "frozen_amount")
    private double frozenAmount;

    @ManyToOne
    private User cardHolder;

    public Account() {
    }


    public Account(User cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(double frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public User getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(User cardHolder) {
        this.cardHolder = cardHolder;
    }
}

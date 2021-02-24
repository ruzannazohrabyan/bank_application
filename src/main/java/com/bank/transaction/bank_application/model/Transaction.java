package com.bank.transaction.bank_application.model;

import jdk.jfr.Category;

import javax.persistence.*;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Account account;
    private double amount;
    private String action;
    private String status;

}

package com.example.bankaccountmanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Accounts {
    protected String name;
    protected double balance;

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public abstract boolean transfer(double amount, Accounts ac);
}

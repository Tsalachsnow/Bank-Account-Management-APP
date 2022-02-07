package com.example.bankaccountmanagement;

import javax.swing.*;

public class SavingsAccount extends Accounts{
    private double interestRate;

    public SavingsAccount(String name, double balance, double interestRate) {
        super(name, balance);
        this.interestRate = interestRate;
    }

    public void addInterest(double amount){
        double interest = amount + amount * interestRate/100;
        deposit(interest);
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        boolean flag = false;
        if(amount <= balance){
            balance -= amount;
            flag = true;
        }
        else
            JOptionPane.showMessageDialog(null, "You don't have enough money in your balance to withdraw");
        return flag;
    }

    @Override
    public boolean transfer(double amount, Accounts ac) {
        boolean flag = false;
        flag = withdraw(amount);
        if(flag)
            ac.deposit(amount);
        return flag;
    }
}

package com.example.bankaccountmanagement;


import javax.swing.*;

public class BankAccount extends Accounts{

    public BankAccount(String name, double balance) {
        super(name, balance);
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
            JOptionPane.showMessageDialog(null,"Insufficient Funds");
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

package com.example.bankaccountmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class UserInterface extends JFrame {
    private static  final long serialVersionUID = 1;
    CardLayout layout = new CardLayout();

    JPanel deck = new JPanel();

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    JTextField name, balance, inrate, amount = new JTextField(), account = new JTextField();
    JLabel label, label2, label3, label4, username, userbalance, amountlabel, accountlabel, interest;

    JButton addCustomerBA, addCustomerSA, login;

    JButton backtomain = new JButton("Go Back");
    JButton deposit = new JButton("Make A Deposit");
    JButton withdraw = new JButton("Withdraw Money");
    JButton transfer = new JButton("Transfer Money");

    List<Accounts> accounts = new ArrayList<>();

    String nameOfUser;

    public UserInterface(){
        deck.setLayout(layout);
        panel.setLayout(null);
        panel2.setLayout(null);

        deck.add(panel, "first");
        deck.add(panel2,"second");

        label = new JLabel("Full Name");
        label.setBounds(10,10,100,20);
        panel.add(label);

        name = new JTextField();
        name.setBounds(120,10,150,20);
        panel.add(name);

        label2 = new JLabel("Balance");
        label2.setBounds(10,40,100,20);
        panel.add(label2);

        balance = new JTextField();
        balance.setBounds(120,40,150,20);
        panel.add(balance);

        label3 = new JLabel("Interest rate");
        label3.setBounds(10,70,100,20);
        panel.add(label3);

        inrate = new JTextField();
        inrate.setBounds(120,70,150,20);
        panel.add(inrate);

        label4 = new JLabel("Add Interest rate only for the Savings Account");
        label4.setBounds(10,95,400,10);
        label4.setFont(new Font("SAN_SERIF", Font.BOLD, 9));
        label4.setForeground(Color.red);
        panel.add(label4);

        addCustomerBA = new JButton("Add Customer to Bank Account");
        addCustomerBA.setBounds(280,25,250,20);
        panel.add(addCustomerBA);

        addCustomerSA = new JButton("Add Customer to Savings Account");
        addCustomerSA.setBounds(280,55,250,20);
        panel.add(addCustomerSA);

        login = new JButton("Login");
        login.setBounds(250,125,100,20);
        panel.add(login);

        addCustomerBA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = name.getText();
                String balance1 = balance.getText();
                boolean found = false;

                if (name1.isEmpty() || balance1.isEmpty()) {
                    if (name1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill in Your Full Name");
                    } else JOptionPane.showMessageDialog(null, "Balance can not be Empty");
                } else if (isNumeric(balance1)) {
                    if (accounts.isEmpty()) {
                        accounts.add(new BankAccount(name1, Double.parseDouble(balance1)));
                        JOptionPane.showMessageDialog(null, "Account Created");
                    } else
                        for (Accounts a : accounts) {
                            if (a.getName().equalsIgnoreCase(name1)) {
                                JOptionPane.showMessageDialog(null, "User Already Has An Account");
                                found = true;
                                break;
                            }

                    if (!found) {
                        accounts.add(new BankAccount(name1, Double.parseDouble(balance1)));
                        JOptionPane.showMessageDialog(null, "New Bank Account Created");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Balance must be a number");
            }
        }

        });
    }
}

package com.example.bankaccountmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


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
        addCustomerSA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = name.getText();
                String balance1 = balance.getText();
                String inrate1 = inrate.getText();
                boolean found = false;
                if(name1.isEmpty() || balance1.isEmpty() || inrate1.isEmpty()){
                  if(name1.isEmpty()){
                      JOptionPane.showMessageDialog(null, "Full Name required");
                  }else if(inrate1.isEmpty()){
                      JOptionPane.showMessageDialog(null, "Inrate required");
                  }else
                      JOptionPane.showMessageDialog(null, "You can't leave Balance empty");
                }else{
                    if(isNumeric(balance1) && isNumeric(inrate1)){
                        if(accounts.isEmpty()){
                            accounts.add(new SavingsAccount(name1, Double.parseDouble(balance1), Double.parseDouble(inrate1)));
                            JOptionPane.showMessageDialog(null, "New Saving Account Created");
                        }else{
                            for(Accounts a : accounts){
                                if(a.getName().equals(name1)){
                                    JOptionPane.showMessageDialog(null, "This User already has an account.");
                                    found = true;
                                    break;
                                }
                                }if(!found){
                                accounts.add(new SavingsAccount(name1,Double.parseDouble(balance1), Double.parseDouble(inrate1)));
                                JOptionPane.showMessageDialog(null, "New Savings Account Created");
                            }
                            }
                        }
                    else{
                        if(!isNumeric(inrate1)){
                            JOptionPane.showMessageDialog(null, "Inrate must be a number");
                        }else
                            JOptionPane.showMessageDialog(null, "Balance must be a number");
                    }
                    }
                }
        });
      username = new JLabel();
      username.setBounds(150,5,150,20);
      username.setForeground(Color.BLUE);
      panel2.add(username);

      userbalance = new JLabel();
      userbalance.setBounds(300,5,150,20);
      userbalance.setForeground(Color.BLUE);
      panel2.add(userbalance);

      amountlabel = new JLabel();
      amountlabel.setText("Amount");
      amountlabel.setBounds(125,35,130,20);
      panel2.add(amountlabel);

      amount.setBounds(210,35,100,20);
      panel2.add(amount);

        deposit.setBounds(150, 65, 200, 20);
        panel2.add(deposit);

        withdraw.setBounds(150, 95, 200, 20);
        panel2.add(withdraw);

        //Label and field for the account
        accountlabel = new JLabel();
        accountlabel.setText("Transfer Account");
        accountlabel.setBounds(100, 125, 130, 20);
        panel2.add(accountlabel);

        account.setBounds(210, 125, 100, 20);
        panel2.add(account);

        //Add the remaining 2 buttons
        transfer.setBounds(150, 155, 200, 20);
        panel2.add(transfer);

        backtomain.setBounds(400, 80, 100, 20);
        panel2.add(backtomain);

        //Label to show how interest works in deposit
        interest = new JLabel();
        interest.setText("<html>If you have a savings account, then the interest will be added every time you make a deposit.<br/E.G. If deposit was 100$ and interest rate was 50%, then your deposit will become 100 + 100(50/100) => 150$</html>");
        interest.setBounds(370, 90, 220, 100);
        interest.setFont(new Font("SAN_SERIF", Font.BOLD, 9));
        interest.setForeground(Color.red);
        panel2.add(interest);

        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = amount.getText(); //Get amount
                amount.setText("");
                String name = nameOfUser;

                if(money.isEmpty()) { //If amount is empty
                    JOptionPane.showMessageDialog(null, "You can't leave Amount empty");
                }
                else {
                    if(isNumeric(money)) { //If amount is a number
                        for(Accounts a : accounts) { //Find user
                            if(a.getName().equals(name)) {
                                if(a.getClass().getName().equals("SavingsAccount")) { //If user's account is a savings one
                                    ((SavingsAccount) a).addInterest(Double.parseDouble(money));
                                    JOptionPane.showMessageDialog(null, "Interest added in deposit." + "\n" + "New balance: " + a.getBalance() + "$");
                                }
                                else {
                                    a.deposit(Double.parseDouble(money));
                                    JOptionPane.showMessageDialog(null, "Deposit made." + "\n" + "New balance: " + a.getBalance() + "$");
                                }
                                userbalance.setText("User Balance: " + a.getBalance() + "$"); //Show their balance
                                break;
                            }
                        }
                    }
                    else //Show message
                        JOptionPane.showMessageDialog(null, "Amount must be a number");
                }
            }
        });

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = amount.getText(); //Get amount
                amount.setText("");
                boolean withd = false;
                String name = nameOfUser;

                if(money.isEmpty()) { //If amount is empty
                    JOptionPane.showMessageDialog(null, "You can't leave Amount empty");
                }
                else {
                    if(isNumeric(money)) { //If amount is a number
                        for(Accounts a : accounts) { //Find user
                            if(a.getName().equals(name)) {
                                withd = a.withdraw(Double.parseDouble(money));
                                if(withd) {
                                    JOptionPane.showMessageDialog(null, "Money withdrawn." + "\n" + "New balance: " + a.getBalance() + "$");
                                    userbalance.setText("User Balance: " + a.getBalance() + "$"); //Show their balance
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    else //Show message
                        JOptionPane.showMessageDialog(null, "Amount must be a number");
                }
            }
        });

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = amount.getText(); //Get amount
                String sendto = account.getText(); //Get account
                amount.setText("");
                account.setText("");
                boolean trans = false;
                boolean flag = false;
                boolean flag1 = false;
                String name = nameOfUser;

                if(money.isEmpty() || sendto.isEmpty()) { //If either amount or account are empty
                    if(sendto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You can't leave Transfer Acount empty");
                    }else
                        JOptionPane.showMessageDialog(null, "You can't leave Amount empty");
                }
                else {
                    if(isNumeric(money)) { //If amount is a number
                        for(Accounts a : accounts) { //Find user account
                            if(a.getName().equals(name)) {
                                flag = true;
                                for(Accounts send : accounts) { //Find account to send
                                    if(send.getName().equals(sendto)) {
                                        flag1 = true;
                                        trans = a.transfer(Double.parseDouble(money), send);
                                        if(trans) {
                                            JOptionPane.showMessageDialog(null, "Money transfered." + "\n" + "New balance: " + a.getBalance() + "$");
                                            userbalance.setText("User Balance: " + a.getBalance() + "$"); //Show their balance
                                        }
                                        break;
                                    }
                                }
                                if(!flag1) { //If user does not exist
                                    JOptionPane.showMessageDialog(null, "User: '" + sendto + "' does not have an account.");
                                }
                            }
                            if(flag) {
                                break;
                            }
                        }
                    }
                    else //Show message
                        JOptionPane.showMessageDialog(null, "Amount must be a number");
                }
            }
        });

        backtomain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                userbalance.setText("");
                amount.setText("");
                account.setText("");
                layout.show(deck, "first");
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = name.getText(); //Get name
                name.setText("");
                balance.setText("");
                inrate.setText("");
                boolean flag = false;
                Accounts acc = null;

                if(name1.isEmpty()) { //If name is empty show message
                    JOptionPane.showMessageDialog(null, "You can't leave Full Name empty");
                }
                else {
                    if(accounts.isEmpty()) { //If there are no users in the list
                        JOptionPane.showMessageDialog(null, "User: '" + name1 + "' does not have an account.");
                    }
                    else { //Check list to find the user
                        for(Accounts a : accounts) {
                            if(a.getName().equals(name1)) {
                                flag = true;
                                acc = a;
                                break;
                            }
                        }
                    }

                    if(flag) { //If you found the user
                        username.setText("User name: " + acc.getName()); //Show their name
                        Double blc = acc.getBalance();
                        userbalance.setText("User Balance: " + blc + "$");//Show their balance1
                        nameOfUser = acc.getName();
                        layout.show(deck, "second");
                    }
                    else //If you does not exist
                        JOptionPane.showMessageDialog(null, "User: '" + name1 + "' does not have an account.");
                }
            }
        });

        layout.show(deck, "first");

        this.add(deck);
        this.setSize(600, 220);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bank");
        this.setVisible(true);
    }

    public static boolean isNumeric(String str) { //See if string is a number
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

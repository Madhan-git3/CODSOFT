package task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM{
    public static void main(String args[]) {
        BankAccount userAccount = new BankAccount(10000);

        JFrame frame = new JFrame("ATM System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 10, 10));  

        JLabel balanceLabel = new JLabel("Balance: $" + userAccount.checkBalance());
        JLabel amountLabel = new JLabel("Enter amount: ");
        JTextField amountField = new JTextField();
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");
        JLabel messageLabel = new JLabel("");

       
        frame.add(balanceLabel);
        frame.add(new JLabel(""));  
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(checkBalanceButton);
        frame.add(exitButton);
        frame.add(messageLabel);

        
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawAmount = Double.parseDouble(amountField.getText());
                    if (withdrawAmount <= 0) {
                        messageLabel.setText("Amount must be greater than 0.");
                    } else if (userAccount.withdraw(withdrawAmount)) {
                        balanceLabel.setText("Balance: $" + userAccount.checkBalance());
                        messageLabel.setText("Successfully withdrew $" + withdrawAmount);
                    } else {
                        messageLabel.setText("Insufficient balance!");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount entered!");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double depositAmount = Double.parseDouble(amountField.getText());
                    if (depositAmount <= 0) {
                        messageLabel.setText("Amount must be greater than 0.");
                    } else {
                        userAccount.deposit(depositAmount);
                        balanceLabel.setText("Balance: $" + userAccount.checkBalance());
                        messageLabel.setText("Successfully deposited $" + depositAmount);
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount entered!");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Current balance: $" + userAccount.checkBalance());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  
            }
        });

        frame.setVisible(true);
    }
}

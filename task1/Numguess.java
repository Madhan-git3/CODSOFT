package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Numguess {
    
    private static int randomNumber;
    private static int tryCount;
    
    private static JTextArea displayArea;
    private static JTextField inputField;
    private static JButton guessButton;
    private static JButton restartButton;
    private static JButton quitButton;

    public static void main(String args[]) {
        
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        Random r = new Random();
        randomNumber = r.nextInt(100) + 1;
        tryCount = 0;

        displayArea = new JTextArea();
        displayArea.setEditable(false); 
        displayArea.setText("Welcome to the Number Guessing Game! \nGuess a number between 1 and 100.\n");
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout()); 

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout()); 
        inputField = new JTextField(20);
        inputPanel.add(inputField);
        bottomPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); 
        guessButton = new JButton("Guess");
        restartButton = new JButton("Play Again");
        restartButton.setEnabled(false); 
        quitButton = new JButton("Quit");

        buttonPanel.add(guessButton);
        buttonPanel.add(restartButton);
        buttonPanel.add(quitButton);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH); 
        frame.add(bottomPanel, BorderLayout.SOUTH);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numGuess = Integer.parseInt(inputField.getText());
                    tryCount++;

                    if (numGuess == randomNumber) {
                        displayArea.append("CORRECT! You've guessed it in " + tryCount + " trials.\n");
                        displayArea.append("Do you want to play again?\n");

                        guessButton.setEnabled(false);  
                        restartButton.setEnabled(true); 
                    } else if (numGuess < randomNumber) {
                        displayArea.append("That's low! Try again.\n");
                    } else {
                        displayArea.append("That's high! Try again.\n");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.append("Invalid input! Please enter a number.\n");
                }
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                randomNumber = r.nextInt(100) + 1;
                tryCount = 0;

                displayArea.setText("New Game! Guess a number between 1 and 100.\n");
                inputField.setText("");
                guessButton.setEnabled(true);
                restartButton.setEnabled(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });

        frame.setVisible(true);
    }
}

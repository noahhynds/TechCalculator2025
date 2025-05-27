package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame implements ActionListener {
    private JTextField textField;
    private double num1;
    private double num2;
    private char operator;

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = ((JButton) e.getSource()).getText();

        if (input.matches("\\d")) {
            textField.setText(textField.getText() + input);
        } else if ("+-*/".contains(input)) {
            num1 = Double.parseDouble(textField.getText());
            operator = input.charAt(0);
            textField.setText("");
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            double result = 0;

            try {
                switch (operator) {
                    case '+':
                        result = Arithmetic.add(num1, num2);
                        break;
                    case '-':
                        result = Arithmetic.subtract(num1, num2);
                        break;
                    case '*':
                        result = Arithmetic.multiply(num1, num2);
                        break;
                    case '/':
                        result = Arithmetic.divide(num1, num2);
                        break;
                }
                textField.setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                textField.setText("Error");
            }
        } else if (input.equals("C")) {
            textField.setText("");
        }
    }
}

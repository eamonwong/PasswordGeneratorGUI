import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;

    public GUI() {
        // initialise the label with a placeholder message
        label = new JLabel("Click the button to generate a password.");

        // create the button
        JButton button = new JButton("Generate Password");
        button.addActionListener(this);

        // create the panel and add the button and label
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 60, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        // set up the frame and display it
        frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Generator");
        frame.pack();
        frame.setVisible(true);
    }

    // handle password generation
    public void actionPerformed(ActionEvent e) {
        String lower_cases = "qwertyuiopasdfghjklzxcvbnm";
        String upper_cases = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String num = "0123456789";
        String specialChars = "`~!@#$%^&*()-_=+:<>/?.,£";
        String combination = lower_cases + upper_cases + num + specialChars;

        // Prompt the user for the desired length of the password
        String input = JOptionPane.showInputDialog(frame, "Enter the desired length of the password:");

        // convert the input to an integer, defaulting to 8 if it cannot be parsed
        int len = 8;
        try {
            len = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input, defaulting to 8.");
        }

        char[] password = new char[len];
        Random r = new Random();

        for (int i = 0; i < len; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }

        // update the label with the generated password
        label.setText("Your generated password is " + new String(password));
    }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }
}






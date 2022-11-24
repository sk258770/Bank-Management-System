import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton saving, fixed, current, recurring;
    JCheckBox atmCard, netBank, mobBank, eAlert, chequeBk, eStatement, declare;

    JButton submit, cancel;
    String formNum;

    String cardNum,pinNum;

    SignupThree(String formNum) {
        this.formNum = formNum;

        setLayout(null);

        JLabel label = new JLabel("Page 3: Account Details");
        label.setBounds(240, 40, 300, 30);
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label);

        JLabel accountType = new JLabel("Account Type");
        accountType.setBounds(80, 100, 300, 30);
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        add(accountType);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(80, 140, 150, 20);
        saving.setBackground(Color.white);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setBounds(80, 170, 150, 20);
        current.setBackground(Color.white);
        add(current);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(280, 140, 200, 20);
        fixed.setBackground(Color.white);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(280, 170, 200, 20);
        recurring.setBackground(Color.white);
        add(recurring);

        ButtonGroup acct = new ButtonGroup();
        acct.add(fixed);
        acct.add(recurring);
        acct.add(current);
        acct.add(saving);

        JLabel card = new JLabel("Card Number");
        card.setBounds(80, 230, 300, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        add(card);

        JLabel cardDetail = new JLabel("Your 16 digit Card Number");
        cardDetail.setBounds(80, 250, 300, 30);
        cardDetail.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(cardDetail);


        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-6398");
        cardNumber.setBounds(250, 230, 300, 30);
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        add(cardNumber);

        JLabel pin = new JLabel("PIN");
        pin.setBounds(80, 300, 300, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        add(pin);

        JLabel pinDetail = new JLabel("Your 4 digit Password");
        pinDetail.setBounds(80, 320, 300, 30);
        pinDetail.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(pinDetail);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setBounds(250, 300, 300, 30);
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        add(pinNumber);

        JLabel service = new JLabel("Services Required:");
        service.setBounds(80, 360, 250, 30);
        service.setFont(new Font("Raleway", Font.BOLD, 18));
        add(service);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBounds(80, 400, 150, 30);
        atmCard.setBackground(Color.white);
        add(atmCard);

        netBank = new JCheckBox("Internet Banking");
        netBank.setBounds(280, 400, 150, 30);
        netBank.setBackground(Color.white);
        add(netBank);

        mobBank = new JCheckBox("Mobile Banking");
        mobBank.setBounds(80, 430, 150, 30);
        mobBank.setBackground(Color.white);
        add(mobBank);

        eAlert = new JCheckBox("Email & SMS Alerts");
        eAlert.setBounds(280, 430, 150, 30);
        eAlert.setBackground(Color.white);
        add(eAlert);

        chequeBk = new JCheckBox("Cheque Book");
        chequeBk.setBounds(80, 460, 150, 30);
        chequeBk.setBackground(Color.white);
        add(chequeBk);

        eStatement = new JCheckBox("E-Statements");
        eStatement.setBounds(280, 460, 150, 30);
        eStatement.setBackground(Color.white);
        add(eStatement);

        declare = new JCheckBox("I hereby declare that the above entered details are correct to the best of my " +
                "knowledge.");
        declare.setBounds(80, 540, 600, 30);
        declare.setBackground(Color.white);
        declare.setFont(new Font("Raleway", Font.BOLD, 12));
        add(declare);

        submit = new JButton("Submit");
        submit.setBounds(200, 580, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        add(submit);
        submit.addActionListener(this);


        cancel = new JButton("Cancel");
        cancel.setBounds(400, 580, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        getContentPane().setBackground(Color.white);

        setVisible(true);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            String accountType = null;
            if (saving.isSelected()) {
                accountType = "Saving Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurring.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random ran = new Random();
            long first7 = ran.nextLong() % 90000000L + 5040936000000000L;
            String cardNum = "" + Math.abs(first7);
            long first3 = ran.nextLong() % 9000L + 1000L;
            String pinNum = "" + Math.abs(first3);
            this.cardNum = cardNum;
            this.pinNum = pinNum;

            String facility = "";
            if (atmCard.isSelected()) {
                facility = facility + " ATM Card";
            } else if (netBank.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (mobBank.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (eAlert.isSelected()) {
                facility = facility + " Email & SMS Alert";
            } else if (chequeBk.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (eStatement.isSelected()) {
                facility = facility + " E-Statement";
            }
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");

                } else {
                    Conn conn = new Conn();
                    String s1 = "insert into signupthree values('" + this.formNum + "','" + accountType + "','" + cardNum + "','" + pinNum + "','" + facility + "')";
                    String s2 = "insert into login values('" + this.formNum + "','" + cardNum + "','" + pinNum + "')";
                    conn.s.executeUpdate(s1);
                    conn.s.executeUpdate(s2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNum + "\n Pin: " + pinNum);

                    setVisible(false);
                    new Deposit(pinNum).setVisible(true);

                }
            } catch (Exception e1) {
                System.out.println(e1);
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login(cardNum, pinNum).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }


}

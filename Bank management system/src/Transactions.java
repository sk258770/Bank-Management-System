import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, cashWithdraw, fastCash, mStatement, pinChange, checkBal, exit;
    String pinNum;

    Transactions(String pinNum) {
        this.pinNum=pinNum;

        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel img = new JLabel(imageIcon1);
        img.setBounds(0, 0, 800, 800);
        add(img);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        img.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(150, 405, 120, 20);
        deposit.setFont(new Font("Raleway", Font.BOLD, 8));
        deposit.setBackground(Color.green);
        deposit.addActionListener(this);
        img.add(deposit);

        cashWithdraw = new JButton("CASH WITHDRAWAL");
        cashWithdraw.setBounds(330, 405, 120, 20);
        cashWithdraw.setFont(new Font("Raleway", Font.BOLD, 8));
        cashWithdraw.setBackground(Color.green);
        cashWithdraw.addActionListener(this);
        img.add(cashWithdraw);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(150, 438, 120, 20);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 8));
        fastCash.setBackground(Color.green);
        fastCash.addActionListener(this);
        img.add(fastCash);

        mStatement = new JButton("MINI STATEMENT");
        mStatement.setBounds(330, 438, 120, 20);
        mStatement.setFont(new Font("Raleway", Font.BOLD, 8));
        mStatement.setBackground(Color.green);
        mStatement.addActionListener(this);
        img.add(mStatement);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(150, 471, 120, 20);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 8));
        pinChange.setBackground(Color.green);
        pinChange.addActionListener(this);
        img.add(pinChange);

        checkBal = new JButton("BALANCE ENQUIRY");
        checkBal.setBounds(330, 471, 120, 20);
        checkBal.setFont(new Font("Raleway", Font.BOLD, 8));
        checkBal.setBackground(Color.green);
        checkBal.addActionListener(this);
        img.add(checkBal);

        exit = new JButton("EXIT");
        exit.setBounds(330, 504, 120, 20);
        exit.setFont(new Font("Raleway", Font.BOLD, 8));
        exit.setBackground(Color.LIGHT_GRAY);
        exit.addActionListener(this);
        img.add(exit);


        setUndecorated(true);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinNum).setVisible(true);
        } else if (ae.getSource()==cashWithdraw) {
            setVisible(false);
            new Withdrawal(pinNum).setVisible(true);
        } else if (ae.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinNum).setVisible(true);
        } else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNum).setVisible(true);
        } else if (ae.getSource()==checkBal) {
            setVisible(false);
            new BalanceEnquiry(pinNum).setVisible(true);
        }else if (ae.getSource()==mStatement){
            new MiniStatement(pinNum).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transactions("");
    }
}

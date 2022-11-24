import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    MiniStatement(String pinNum) {

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("system", Font.BOLD, 16));
        bank.setBounds(150, 30, 100, 40);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(30, 40, 300, 100);
        card.setFont(new Font("system", Font.BOLD, 13));
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(30, 100, 400, 100);
        add(mini);

        int balance = 0;



        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from login where pinNum ='" + pinNum + "'");
            if (rs.next()) {
                card.setText("CARD NO: XXXX-XXXX-XXXX-" + rs.getString("cardNum").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinNum ='" + pinNum + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                            rs.getString("amount") + "<br>" + "<html>");
                    balance = balance + Integer.parseInt(rs.getString("amount"));


                } else {
                    mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;" +
                            rs.getString("amount") + "<br>" + "<html>");
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (
                Exception e) {
            System.out.println(e);

        }

        JLabel bal = new JLabel("Your account balance is "+ balance);
        bal.setBounds(30, 500, 400, 30);
        add(bal);

        setLayout(null);

        setSize(400, 600);

        setLocation(200, 100);

        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");

    }
}

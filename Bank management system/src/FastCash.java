import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rs500, rs1000, rs2000, rs5000, rs10000, rs20000, back;

    String pinNum;

    FastCash(String pinNum) {
        this.pinNum=pinNum;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = icon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(image);

        JLabel img = new JLabel(imageIcon);
        img.setBounds(0, 0, 800, 800);
        add(img);

        JLabel text = new JLabel("Please select your Withdrawal amount");
        text.setBounds(155, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        img.add(text);

        rs500 = new JButton("RS 500");
        rs500.setBounds(150, 405, 120, 20);
        rs500.setFont(new Font("Raleway", Font.BOLD, 8));
        rs500.setBackground(Color.green);
        rs500.addActionListener(this);
        img.add(rs500);

        rs1000 = new JButton("RS 1000");
        rs1000.setBounds(330, 405, 120, 20);
        rs1000.setFont(new Font("Raleway", Font.BOLD, 8));
        rs1000.setBackground(Color.green);
        rs1000.addActionListener(this);
        img.add(rs1000);

        rs2000 = new JButton("RS 2000");
        rs2000.setBounds(150, 438, 120, 20);
        rs2000.setFont(new Font("Raleway", Font.BOLD, 8));
        rs2000.setBackground(Color.green);
        rs2000.addActionListener(this);
        img.add(rs2000);

        rs5000 = new JButton("RS 5000");
        rs5000.setBounds(330, 438, 120, 20);
        rs5000.setFont(new Font("Raleway", Font.BOLD, 8));
        rs5000.setBackground(Color.green);
        rs5000.addActionListener(this);
        img.add(rs5000);

        rs10000 = new JButton("RS 10000");
        rs10000.setBounds(150, 471, 120, 20);
        rs10000.setFont(new Font("Raleway", Font.BOLD, 8));
        rs10000.setBackground(Color.green);
        rs10000.addActionListener(this);
        img.add(rs10000);

        rs20000 = new JButton("RS 20000");
        rs20000.setBounds(330, 471, 120, 20);
        rs20000.setFont(new Font("Raleway", Font.BOLD, 8));
        rs20000.setBackground(Color.green);
        rs20000.addActionListener(this);
        img.add(rs20000);

        back = new JButton("BACK");
        back.setBounds(330, 504, 120, 20);
        back.setFont(new Font("system", Font.BOLD, 8));
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        img.add(back);

        setLayout(null);
        setUndecorated(true);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNum);

        } else {
            String amt = ((JButton) ae.getSource()).getText().substring(3);

            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinNum ='" + pinNum + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance < Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date =new Date();
                String query = "insert into bank values ('"+pinNum+"','"+date+"','Withdrawal','"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+amt+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNum).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }

}

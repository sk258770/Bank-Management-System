import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry  extends JFrame implements ActionListener {
    String pinNum;
    JButton back;
    BalanceEnquiry(String pinNum){
        this.pinNum=pinNum;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1= new ImageIcon(image);

        JLabel img = new JLabel(imageIcon1);
        img.setBounds(0,0,800,800);
        add(img);

        int balance =0;

        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pinNum ='" + pinNum + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your account balance is "+ balance);
        text.setBounds(150,300,300,20);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        img.add(text);

        back = new JButton("BACK");
        back.setBounds(330, 504, 120, 20);
        back.setFont(new Font("System", Font.BOLD, 8));
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        img.add(back);

        setLayout(null);
        setSize(800,800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);




    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

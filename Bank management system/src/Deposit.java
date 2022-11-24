import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {
    JTextField amt;

    JButton deposit,back;

    String pinNum;
    Deposit(String pinNum) {
        this.pinNum = pinNum;

        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel img = new JLabel(imageIcon1);
        img.setBounds(0, 0, 800, 800);
        add(img);

        JLabel text = new JLabel("Enter the amount your want to deposit ");
        text.setBounds(180,300,400,35);
        text.setFont(new Font("system",Font.BOLD,13));
        text.setForeground(Color.white);
        img.add(text);

        amt= new JTextField();
        amt.setBounds(180,350,240,23);
        amt.setFont(new Font("system",Font.BOLD,16));
        img.add(amt);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(330,471,120,20);
        deposit.setFont(new Font("Raleway",Font.BOLD,8));
        deposit.setBackground(Color.green);
        img.add(deposit);
        deposit.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(330,504,120,20);
        back.setFont(new Font("Raleway",Font.BOLD,8));
        back.setBackground(Color.lightGray);
        img.add(back);
        back.addActionListener(this);

        setUndecorated(true);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);



    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            String amount = amt.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                try{
                    Conn conn = new Conn();
                    String s1 = "insert into bank values('"+pinNum+"','"+date+"','Deposit','"+amount+"')";
                    conn.s.executeUpdate(s1);
                    JOptionPane.showMessageDialog(null,"RS. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);

                }catch (Exception e){
                    System.out.println(e);
                }
            }

        } else if (ae.getSource()==back) {
            new Transactions(pinNum).setVisible(true);

        }

    }


    public static void main(String[] args) {
        new Deposit("");
    }
}

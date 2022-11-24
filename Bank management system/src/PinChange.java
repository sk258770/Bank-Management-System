import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField newPin,rePin;

    JButton change, back;

    String pinNum;

    PinChange(String pinNum) {

        this.pinNum = pinNum;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel img = new JLabel(imageIcon1);
        img.setBounds(0, 0, 800, 800);
        add(img);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(225, 300, 500, 35);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setForeground(Color.white);
        img.add(text);

        JLabel pinText = new JLabel("New PIN");
        pinText.setBounds(180, 350, 200, 35);
        pinText.setBackground(Color.white);
        pinText.setFont(new Font("system", Font.BOLD, 13));
        pinText.setForeground(Color.white);
        img.add(pinText);

        newPin = new JPasswordField();
        newPin.setBounds(338, 356, 100, 20);
        newPin.setFont(new Font("system", Font.BOLD, 16));
        img.add(newPin);

        JLabel rePinText = new JLabel("Re-enter new PIN");
        rePinText.setBounds(180, 400, 200, 35);
        rePinText.setFont(new Font("system", Font.BOLD, 13));
        rePinText.setBackground(Color.white);
        rePinText.setForeground(Color.white);
        img.add(rePinText);

        rePin = new JPasswordField();
        rePin.setBounds(338, 406, 100, 20);
        rePin.setFont(new Font("system", Font.BOLD, 16));
        img.add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(330, 471, 120, 20);
        change.setBackground(Color.green);
        change.setFont(new Font("system", Font.BOLD, 8));
        img.add(change);
        change.addActionListener(this);

        back = new JButton("BACK");
        back.setBackground(Color.LIGHT_GRAY);
        back.setBounds(330, 504, 120, 20);
        back.setFont(new Font("system", Font.BOLD, 8));
        img.add(back);
        back.addActionListener(this);


        setLayout(null);
        setSize(800, 800);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String nPin = newPin.getText();
                String rPin = rePin.getText();

                if (!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                }
                if(nPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN ");
                }
                if(rPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                }
                Conn c = new Conn();
                String s1="update bank set pinNum ='"+rPin+"' where pinNum = '"+pinNum+"'";
                String s2="update login set pinNum ='"+rPin+"' where pinNum = '"+pinNum+"'";
                String s3="update signupthree set pinNum ='"+rPin+"' where pinNum = '"+pinNum+"'";

                c.s.executeUpdate(s1);
                c.s.executeUpdate(s2);
                c.s.executeUpdate(s3);

                JOptionPane.showMessageDialog(null,"PIN Changed successfully");
                setVisible(false);
                new Transactions(rPin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("");
    }

}

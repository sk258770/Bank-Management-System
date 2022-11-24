import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(String cardNum,String pinNum){
        this();
        cardTextField.setText(cardNum);
        pinTextField.setText(pinNum);

    }
    Login(){

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(80,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(220,40,400,40);
        add(text);


        JLabel cardno = new JLabel("Card no: ");
        cardno.setFont(new Font("Osward", Font.BOLD,28));
        cardno.setBounds(120,150,200,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(250,150,250,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,20));
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Osward", Font.BOLD,28));
        pin.setBounds(120,220,200,40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(250,220,250,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,20));
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(250,300,100,40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(400,300,100,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(250,380,250,40);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);




        getContentPane().setBackground(Color.white);

        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource()==login) {
            Conn conn = new Conn();
            String cardNum = cardTextField.getText();
            String pinNum =pinTextField.getText();
            String query="select * from login where cardNum = '"+cardNum+"' And pinNum = '"+pinNum+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNum);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Login();
    }

}

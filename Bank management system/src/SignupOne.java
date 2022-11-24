import com.toedter.calendar.JDateChooser;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {
    int random;
    JTextField nameF, fnameF, emailF, addressF, cityF, pinF, stateF;
    JButton next;
    JRadioButton male, female, others, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {
        setLayout(null);

        Random ran = new Random();
        //long random = Math.abs((ran.nextLong()%9000L)+1000L);
        random = ran.nextInt((9999 - 100) + 1) + 10;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(65, 5, 80, 80);
        add(label);


        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        formno.setBounds(170, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details ");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(280, 60, 400, 40);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 100, 200, 40);
        add(name);

        nameF = new JTextField();
        nameF.setBounds(260, 105, 300, 30);
        nameF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(nameF);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 140, 200, 40);
        add(fname);

        fnameF = new JTextField();
        fnameF.setBounds(260, 145, 300, 30);
        fnameF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(fnameF);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 180, 200, 40);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(260, 185, 300, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);


        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 220, 200, 40);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(260, 228, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(350, 228, 80, 30);
        female.setBackground(Color.white);
        add(female);


        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);


        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 260, 200, 40);
        add(email);

        emailF = new JTextField();
        emailF.setBounds(260, 265, 300, 30);
        emailF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(emailF);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 300, 200, 40);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(260, 308, 80, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(350, 308, 90, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(450, 308, 100, 30);
        others.setBackground(Color.white);
        add(others);

        ButtonGroup maritalGroup2 = new ButtonGroup();
        maritalGroup2.add(married);
        maritalGroup2.add(unmarried);
        maritalGroup2.add(others);


        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 340, 200, 40);
        add(address);

        addressF = new JTextField();
        addressF.setBounds(260, 345, 300, 30);
        addressF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(addressF);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 380, 200, 40);
        add(city);

        cityF = new JTextField();
        cityF.setBounds(260, 385, 300, 30);
        cityF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(cityF);

        JLabel pin = new JLabel("Pin Code: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 420, 200, 40);
        add(pin);

        pinF = new JTextField();
        pinF.setBounds(260, 425, 300, 30);
        pinF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(pinF);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 460, 200, 40);
        add(state);

        stateF = new JTextField();
        stateF.setBounds(260, 465, 300, 30);
        stateF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(stateF);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(480, 550, 70, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(700, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nameF.getText();
        String fname = fnameF.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailF.getText();

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (others.isSelected()) {
            marital = "Others";
        }
        String address = addressF.getText();
        String city = cityF.getText();
        String state = stateF.getText();
        String pin = pinF.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn con = new Conn();
                String s1 = "Insert into signup values ('" + formno + "','" + name + "','" + fname + "','" + dob + "'," +
                        "'" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state +
                        "','" + pin + "')";
                con.s.executeUpdate(s1);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }

    }


    public static void main(String[] args) {
        new SignupOne();
    }

}

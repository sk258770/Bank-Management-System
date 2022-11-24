import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {
    int random;

    JComboBox religionBox, categoryBox, incomeBox, eduBox, occupationBox;
    JTextField panF, aadhaarF;
    JButton next;
    JRadioButton yesSenior, noSenior, yesExists, noExists;
    String formNum;

    SignupTwo(String formNum) {
        setLayout(null);

        this.formNum = formNum;
        setTitle("NEW ACCOUNT APPLICATION FORM");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(280, 60, 400, 40);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 100, 200, 40);
        add(religion);

        String[] religionVal = {"Hindu", "Muslim", "Christian", "sikh", "Others"};
        religionBox = new JComboBox(religionVal);
        religionBox.setBounds(280, 105, 300, 30);
        religionBox.setFont(new Font("Arial", Font.PLAIN, 18));
        religionBox.setBackground(Color.white);
        add(religionBox);


        JLabel category = new JLabel("Category ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 140, 200, 40);
        add(category);

        String[] categoryVal = {"General", "OBC", "SC", "ST", "others"};

        categoryBox = new JComboBox<>(categoryVal);
        categoryBox.setBounds(280, 145, 300, 30);
        categoryBox.setFont(new Font("Arial", Font.PLAIN, 18));
        categoryBox.setBackground(Color.white);
        add(categoryBox);


        JLabel income = new JLabel("Income ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 180, 200, 40);
        add(income);

        String[] incomeVal = {"null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomeBox = new JComboBox<>(incomeVal);
        incomeBox.setBounds(280, 185, 300, 30);
        incomeBox.setFont(new Font("Arial", Font.PLAIN, 18));
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        JLabel education = new JLabel("Education ");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 220, 200, 40);
        add(education);

        JLabel qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 245, 200, 40);
        add(qualification);

        String[] eduVal = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        eduBox = new JComboBox(eduVal);
        eduBox.setBounds(280, 240, 300, 30);
        eduBox.setFont(new Font("Arial", Font.PLAIN, 18));
        eduBox.setBackground(Color.white);
        add(eduBox);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 300, 200, 40);
        add(occupation);

        String[] occupationVal = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationBox = new JComboBox(occupationVal);
        occupationBox.setFont(new Font("Raleway", Font.PLAIN, 18));
        occupationBox.setBounds(280, 308, 300, 30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);


        JLabel pan = new JLabel("PAN Number ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 340, 200, 40);
        add(pan);

        panF = new JTextField();
        panF.setBounds(280, 345, 300, 30);
        panF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(panF);

        JLabel aadhaar = new JLabel("Aadhaar Number ");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaar.setBounds(100, 380, 200, 40);
        add(aadhaar);

        aadhaarF = new JTextField();
        aadhaarF.setBounds(280, 385, 300, 30);
        aadhaarF.setFont(new Font("Arial", Font.PLAIN, 18));
        add(aadhaarF);

        JLabel seniorCitizen = new JLabel("Senior Citizen ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 420, 200, 40);
        add(seniorCitizen);

        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(280, 428, 100, 30);
        yesSenior.setFont(new Font("Arial", Font.PLAIN, 18));
        yesSenior.setBackground(Color.white);
        add(yesSenior);

        noSenior = new JRadioButton("No");
        noSenior.setBounds(400, 428, 100, 30);
        noSenior.setFont(new Font("Arial", Font.PLAIN, 18));
        noSenior.setBackground(Color.white);
        add(noSenior);

        ButtonGroup seniorGrp = new ButtonGroup();
        seniorGrp.add(yesSenior);
        seniorGrp.add(noSenior);


        JLabel existingAccount = new JLabel("Existing Account ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 460, 200, 40);
        add(existingAccount);

        yesExists = new JRadioButton("Yes");
        yesExists.setBounds(280, 468, 100, 30);
        yesExists.setFont(new Font("Arial", Font.PLAIN, 18));
        yesExists.setBackground(Color.white);
        add(yesExists);

        noExists = new JRadioButton("No");
        noExists.setBounds(400, 468, 100, 30);
        noExists.setFont(new Font("Arial", Font.PLAIN, 18));
        noExists.setBackground(Color.white);
        add(noExists);

        ButtonGroup existGrp = new ButtonGroup();
        existGrp.add(yesExists);
        existGrp.add(noExists);


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

        String formNo = formNum;
        String sReligion = (String) religionBox.getSelectedItem();
        String sCategory = (String) categoryBox.getSelectedItem();
        String sIncome = (String) incomeBox.getSelectedItem();
        String sEducation = (String) eduBox.getSelectedItem();
        String sOccupation = (String) occupationBox.getSelectedItem();
        String sPanNumber = panF.getText();
        String sAadhaarNumber = aadhaarF.getText();

        String sSeniorCitizen = null;
        if (yesSenior.isSelected()) {
            sSeniorCitizen = "Yes";
        } else if (noSenior.isSelected()) {
            sSeniorCitizen = "No";
        }


        String sExistingAccount = null;
        if (yesExists.isSelected()) {
            sExistingAccount = "Yes";
        } else if (noExists.isSelected()) {
            sExistingAccount = "No";
        }


        try {
            Conn con = new Conn();
            String s1 = "Insert into signuptwo values ('" + formNo + "','" + sReligion + "','" + sCategory + "','" + sIncome +
                    "'," + "'" + sEducation+ "','" + sOccupation + "','" + sPanNumber + "','" + sAadhaarNumber + "'," +
                    "'" + sSeniorCitizen + "','" + sExistingAccount + "')";
            con.s.executeUpdate(s1);
            setVisible(false);
            new SignupThree(formNum).setVisible(true);
        } catch(Exception e1){

        System.out.println(e1);
    }

}


    public static void main(String[] args) {
        new SignupTwo("");
    }

}


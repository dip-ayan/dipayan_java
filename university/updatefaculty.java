package university;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class updatefaculty extends JFrame implements ActionListener {
    JTextField tfaddress, tfphone, tfemail, lcourse, lbranch;
    JLabel labelroll;
    Choice cempid;
    JButton submit, cancel;

    updatefaculty() {

        setVisible(true);
        setSize(871, 623);
        setLocation(250, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(310, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        labelroll = new JLabel("Select Emp Id");
        labelroll.setBounds(50, 70, 150, 20);
        labelroll.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelroll);

        cempid = new Choice();
        cempid.setBounds(210, 70, 150, 20);
        add(cempid);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from faculty");
            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel tfname = new JLabel();
        tfname.setBounds(200, 150, 150, 30);
        tfname.setFont(new Font("serif", Font.BOLD, 20));
        add(tfname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel tffname = new JLabel();
        tffname.setBounds(600, 150, 150, 30);
        tffname.setFont(new Font("serif", Font.BOLD, 20));
        add(tffname);

        JLabel roll = new JLabel("Roll No");
        roll.setBounds(50, 200, 100, 30);
        roll.setFont(new Font("serif", Font.BOLD, 20));
        add(roll);

        JLabel tfroll = new JLabel("Empid");
        tfroll.setBounds(200, 200, 100, 30);
        tfroll.setFont(new Font("serif", Font.BOLD, 20));
        add(tfroll);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        JLabel ldob = new JLabel();
        ldob.setBounds(600, 200, 200, 30);
        ldob.setFont(new Font("serif", Font.BOLD, 20));
        add(ldob);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        tfaddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfaddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(450, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        tfphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfphone);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("serif", Font.BOLD, 20));
        email.setBounds(50, 300, 200, 30);
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        tfemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfemail);

        JLabel x = new JLabel("Class X(%)");
        x.setBounds(400, 300, 200, 30);
        x.setFont(new Font("serif", Font.BOLD, 20));
        add(x);

        JLabel tfx = new JLabel();
        tfx.setBounds(600, 300, 150, 30);
        tfx.setFont(new Font("serif", Font.BOLD, 20));
        add(tfx);

        JLabel xii = new JLabel("Class XII(%)/ITI");
        xii.setBounds(50, 350, 200, 30);
        xii.setFont(new Font("serif", Font.BOLD, 20));
        add(xii);

        JLabel tfxii = new JLabel();
        tfxii.setBounds(220, 350, 150, 30);
        tfxii.setFont(new Font("serif", Font.BOLD, 20));
        add(tfxii);

        JLabel adhar = new JLabel("Aadhar No");
        adhar.setBounds(400, 350, 200, 30);
        adhar.setFont(new Font("serif", Font.BOLD, 20));
        add(adhar);

        JLabel tfadhar = new JLabel();
        tfadhar.setBounds(600, 350, 150, 30);
        tfadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(tfadhar);

        JLabel course = new JLabel("Education");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        lcourse = new JTextField();
        lcourse.setBounds(200, 400, 150, 30);
        lcourse.setFont(new Font("serif", Font.PLAIN, 20));
        add(lcourse);

        JLabel branch = new JLabel("Department");
        branch.setBounds(400, 400, 200, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        lbranch = new JTextField();
        lbranch.setBounds(600, 400, 150, 30);
        lbranch.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbranch);

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

        try {
            conn c = new conn();
            String query = "select * from faculty where empid='" + cempid.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {

                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfroll.setText(rs.getString("empid"));
                ldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfx.setText(rs.getString("class_x"));
                tfxii.setText(rs.getString("class_xii"));
                tfadhar.setText(rs.getString("adhar"));
                lcourse.setText(rs.getString("qualification"));
                lbranch.setText(rs.getString("department"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        cempid.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from faculty where empid='" + cempid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {

                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                        tfroll.setText(rs.getString("rollno"));
                        ldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfx.setText(rs.getString("class_x"));
                        tfxii.setText(rs.getString("class_xii"));
                        tfadhar.setText(rs.getString("adhar"));
                        lcourse.setText(rs.getString("qualification"));
                        lbranch.setText(rs.getString("department"));
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        });

    }

    public static void main(String[] args) {
        new updatefaculty();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String empid = labelroll.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification = lcourse.getText();
            String department = lbranch.getText();
            try {
                conn c = new conn();

                String query = "update faculty set address ='" + address + "',phone='" + phone + "',email= '" + email
                        + "',qualification='" + qualification + "',department='" + department + "'where empid='"+empid+"'";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
            new project().setVisible(true);
        }

    }

    

}

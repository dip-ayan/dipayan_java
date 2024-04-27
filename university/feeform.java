package university;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class feeform extends JFrame implements ActionListener {

    JLabel labelroll, labelsem, total1;
    Choice crollno;
    JComboBox cbcourse, cbbranch, semester;
    JButton update, pay, back;

    feeform() {

        setVisible(true);
        setSize(900, 500);
        setLocation(300, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        labelroll = new JLabel("Select Roll No");
        labelroll.setBounds(40, 60, 150, 20);
        labelroll.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelroll);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel tfname = new JLabel();
        tfname.setBounds(200, 100, 150, 20);
        tfname.setFont(new Font("serif", Font.BOLD, 16));
        add(tfname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(40, 140, 150, 20);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel tffname = new JLabel();
        tffname.setBounds(200, 140, 150, 20);
        tffname.setFont(new Font("serif", Font.BOLD, 16));
        add(tffname);

        try {
            conn c = new conn();
            String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {

                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        crollno.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {

                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        });

        JLabel course = new JLabel("Course");
        course.setBounds(40, 180, 150, 20);
        course.setFont(new Font("serif", Font.BOLD, 18));
        add(course);

        String acourse[] = { "B.Tech", "BCA", "BBA", "Polytechnic" };
        cbcourse = new JComboBox(acourse);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(40, 220, 150, 20);
        branch.setFont(new Font("serif", Font.BOLD, 18));
        add(branch);

        String abranch[] = { "CST", "Mechanical", "Electrical", "Civil" };
        cbbranch = new JComboBox(abranch);
        cbbranch.setBounds(200, 220, 150, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        labelsem = new JLabel(" Semester");
        labelsem.setBounds(40, 260, 150, 20);
        labelsem.setFont(new Font("serif", Font.BOLD, 20));
        add(labelsem);

        String asemester[] = { "Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6" };
        semester = new JComboBox(asemester);
        semester.setBounds(200, 260, 150, 20);
        semester.setBackground(Color.WHITE);
        add(semester);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40, 300, 150, 30);
        total.setFont(new Font("serif", Font.BOLD, 20));
        add(total);

        total1 = new JLabel();
        total1.setBounds(200, 300, 150, 20);
        total1.setFont(new Font("serif", Font.PLAIN, 20));
        add(total1);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 14));
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tahoma", Font.BOLD, 14));
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

    }

    public static void main(String[] args) {
        new feeform();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==update){
            String course=(String)cbcourse.getSelectedItem();
            String csemester=(String)semester.getSelectedItem();
            try{
                conn c=new conn();
                ResultSet rs= c.s.executeQuery("select * from fees where course='"+course+"'");
                while(rs.next()){
                    total1.setText(rs.getString(csemester));
                }

            }
            catch(Exception e){
                System.out.println(e);
            }


        }
        else if(ae.getSource()== pay){

            String rollno=(String)crollno.getSelectedItem();
            String course=(String)cbcourse.getSelectedItem();
            String csemester=(String)semester.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            String total2=total1.getText();

            try{

                conn c=new conn();

                String query="insert into collegefees values('"+rollno+"','"+course+"','"+branch+"','"+csemester+"','"+total2+"')";
                 c.s.executeUpdate(query);

                 JOptionPane.showMessageDialog(null,"College fee submitted Successfully");
                 setVisible(false);
                
            }
        
            catch(Exception e){
                System.out.println(e);

            }
        

        }
        else{
            setVisible(false);
            new project().setVisible(true);
        }
}
}

package university;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class facultyleave extends JFrame implements ActionListener {
    Choice cempid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;

    facultyleave() {
        setVisible(true);
        setSize(500, 500);
        setLocation(500, 100);
        setLayout(null);

        JLabel heading = new JLabel("Apply for Leave(Faculty)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        JLabel empid = new JLabel("Search By Emp ID");
        empid.setBounds(60, 100, 200, 30);
        empid.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(empid);

        cempid = new Choice();
        cempid.setBounds(60, 130, 200, 20);
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

        JLabel date = new JLabel("Date");
        date.setBounds(60, 180, 200, 20);
        date.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(date);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 20);
        add(dcdate);

        JLabel time = new JLabel("Time");
        time.setBounds(60, 260, 200, 20);
        time.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(time);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

    }

    public static void main(String[] args) {
        new facultyleave();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String empid=cempid.getSelectedItem();
            String date=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration= ctime.getSelectedItem();

            String query="insert into facultyleave values('"+empid+"','"+date+"','"+duration+"')";
            try{
                conn c= new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Applied Successfully");
                setVisible(false);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new project().setVisible(true);
        }

    }
}

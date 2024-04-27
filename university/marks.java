package university;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class marks extends JFrame implements ActionListener {
    String rollno;
    JButton cancel;

    marks(String rollno) {
        this.rollno = rollno;

        setVisible(true);
        setSize(500, 600);
        setLocation(500, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Rajendranath College of Polytechnic");
        heading.setBounds(75, 10, 500, 25);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result Of Examination 2024");
        subheading.setBounds(100, 50, 500, 25);
        subheading.setFont(new Font("serif", Font.BOLD, 20));
        add(subheading);

        JLabel lrollno = new JLabel("Roll no --" + rollno);
        lrollno.setBounds(60, 100, 500, 25);
        lrollno.setFont(new Font("serif", Font.PLAIN, 18));
        add(lrollno);

        JLabel semester = new JLabel("Semester");
        semester.setBounds(60, 130, 500, 25);
        semester.setFont(new Font("serif", Font.PLAIN, 18));
        add(semester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(60, 200, 500, 25);
        sub1.setFont(new Font("serif", Font.PLAIN, 20));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(60, 230, 500, 25);
        sub2.setFont(new Font("serif", Font.PLAIN, 20));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(60, 260, 500, 25);
        sub3.setFont(new Font("serif", Font.PLAIN, 20));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(60, 290, 500, 25);
        sub4.setFont(new Font("serif", Font.PLAIN, 20));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(60, 320, 500, 25);
        sub5.setFont(new Font("serif", Font.PLAIN, 20));
        add(sub5);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from marks where rollno='" + rollno + "'");
            while (rs.next()) {
                sub1.setText(rs.getString("subject1"));
                sub2.setText(rs.getString("subject2"));
                sub3.setText(rs.getString("subject3"));
                sub4.setText(rs.getString("subject4"));
                sub5.setText(rs.getString("subject5"));

                sub1.setText(sub1.getText() + "------------" + rs.getString("marks1"));
                sub2.setText(sub2.getText() + "------------" + rs.getString("marks2"));
                sub3.setText(sub3.getText() + "------------" + rs.getString("marks3"));
                sub4.setText(sub4.getText() + "------------" + rs.getString("marks4"));
                sub5.setText(sub5.getText() + "------------" + rs.getString("marks5"));
                semester.setText("Semester --"+rs.getString("semester"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

    }

    public static void main(String[] args) {
        new marks("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new examdetails().setVisible(true);
        
    }

}

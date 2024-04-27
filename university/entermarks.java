package university;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class entermarks extends JFrame implements ActionListener{

    JLabel labelroll,labelsem,labelsub,labelmarks;
    Choice crollno;
    JComboBox semester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;

    entermarks(){
        setVisible(true);
        setSize(1000,500);
        setLocation(250,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2= i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Student Marks");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        labelroll = new JLabel("Select Roll No");
        labelroll.setBounds(50, 70, 150, 20);
        labelroll.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelroll);

        crollno = new Choice();
        crollno.setBounds(210, 70, 150, 20);
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

        labelsem = new JLabel("Select Semester");
        labelsem.setBounds(50, 120, 150, 20);
        labelsem.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsem);

        String asemester[] = { "First", "Second", "Third", "Fourth","Fifth","Sixth" };
        semester = new JComboBox(asemester);
        semester.setBounds(210, 120, 150, 20);
        semester.setBackground(Color.WHITE);
        add(semester);

        labelsub = new JLabel("Enter Subject");
        labelsub.setBounds(100, 150, 200, 40);
        labelsub.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsub);

        labelmarks = new JLabel("Enter Marks");
        labelmarks.setBounds(320, 150, 200, 40);
        labelmarks.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 200, 200, 30);
        tfsub1.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 30);
        tfsub2.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 260, 200, 30);
        tfsub3.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 290, 200, 30);
        tfsub4.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 320, 200, 30);
        tfsub5.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 200, 200, 30);
        tfmarks1.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 230, 200, 30);
        tfmarks2.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 260, 200, 30);
        tfmarks3.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 290, 200, 30);
        tfmarks4.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250, 320, 200, 30);
        tfmarks5.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);
    }

    public static void main(String[] args) {
        new entermarks();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){

            String semester1 = (String)semester.getSelectedItem();
            try{

                conn c=new conn();
                String query1= "insert into marks values('"+crollno.getSelectedItem()+"','"+semester1+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Student Marks Inserted Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else if (ae.getSource()==cancel){
            setVisible(false);
            new project().setVisible(true);
        }

       
    }
    
}

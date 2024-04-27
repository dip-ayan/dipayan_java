package university;

import java.awt.*;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class newfaculty  extends JFrame implements ActionListener{
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran=new Random();
    long first4= Math.abs((ran.nextLong()%9000L)+1000L);

    newfaculty(){

     

        setVisible(true);
        setSize(871,623);
        setLocation(250,50);
        setLayout(null);

        JLabel heading =new JLabel("New Faculty Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name =new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel fname =new JLabel("Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel empid= new JLabel("Emp ID");
        empid.setBounds(50,200,100,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);        
         
        labelempid =new JLabel("1000"+first4);
         labelempid.setBounds(200,200,200,30);
         labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);

        JLabel dob =new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        JLabel address =new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,200,30);
        add(tfaddress);

        JLabel phone =new JLabel("Phone");
        phone.setBounds(450,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel email =new JLabel("Email");
        email.setFont(new Font("serif",Font.BOLD,20));
        email.setBounds(50,300,200,30);
        add(email);

        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel x =new JLabel("Class X(%)");
        x.setBounds(400,300,200,30);
        x.setFont(new Font("serif",Font.BOLD,20));
        add(x);

        tfx=new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel xii =new JLabel("Class XII(%)/ITI");
        xii.setBounds(50,350,200,30);
        xii.setFont(new Font("serif",Font.BOLD,20));
        add(xii);

        tfxii=new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        JLabel adhar =new JLabel("Aadhar No");
        adhar.setBounds(400,350,200,30);
        adhar.setFont(new Font("serif",Font.BOLD,20));
        add(adhar);

        tfadhar=new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add(tfadhar);

        JLabel course =new JLabel("Qualification");
        course.setBounds(50,400,200,30);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);

        String acourse[]={"B.Tech","BCA","BBA","Polytechnic"};
        cbcourse=new JComboBox(acourse);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel branch =new JLabel("Department");
        branch.setBounds(400,400,200,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);

        String abranch[]={"CST","Mechanical","Electrical","Civil"};
        cbbranch=new JComboBox(abranch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit=new JButton("Submit");
        submit.setBounds(250,500,120,30);                            
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);

         cancel=new JButton("Cancel");
        cancel.setBounds(450,500,120,30);                            
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);








        






    }
    public static void main(String[] args) {
        new newfaculty();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String name= tfname.getText();
            String fname= tffname.getText();
            String empid=labelempid.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address= tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String x= tfx.getText();
            String xii= tfxii.getText();
            String adhar= tfadhar.getText();
            String qualification= (String)cbcourse.getSelectedItem();
            String department= (String)cbbranch.getSelectedItem();
            try{
                conn c=new conn();

                String query="INSERT INTO faculty VALUES ('" +name + "','" + fname+ "', '" + empid + "', '" + dob + "', '" + address+ "','" + phone + "', '"+ email+ "', '" + x + "', '" + xii + "', '" + adhar + "','" + qualification + "','" + department + "')"; 
            
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Faculty Details Inserted Successfully");
                setVisible(false);
            }
                catch(Exception e){
               System.out.println(e);
            }









        }
        else if(ae.getSource()==cancel){

            setVisible(false);
        }
        
    }
    
}


package university;

import javax.swing.*;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField tfusername;
    JPasswordField tfpassword;

    login(){

        setVisible(true);
        setSize(600,300);
        setLocation(380,250);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username=new JLabel("UserName:");
        username.setBounds(40,20,100,20);
        add(username);

         tfusername=new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);

        JLabel password=new JLabel("Password:");
        password.setBounds(40,70,100,20);
        add(password);

         tfpassword=new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

         login=new JButton("Login");
        login.setBounds(40,140,120,30);                            
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma",Font.BOLD,14));
        login.addActionListener(this);
        add(login);

         cancel=new JButton("Cancel");
        cancel.setBounds(180,140,120,30);                            
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);


    }

    public static void main(String[] args) {
        new login();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==login){
        String username=tfusername.getText();
        String password=tfpassword.getText();
        String query= "select * from login where username='"+username+"' and password='"+password+"'";
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new project();

            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);

            }

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

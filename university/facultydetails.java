package university;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.*;



public class facultydetails extends JFrame implements ActionListener {

    Choice cempid;
    JTable table;
    JButton search,print,update,add,cancel;

    facultydetails(){
        setVisible(true);
        setSize(871,623);
        setLocation(250,50);
        setLayout(null);

        JLabel heading =new JLabel("Search By Emp ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        cempid=new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);

        try{
            conn c=new conn();
            ResultSet rs= c.s.executeQuery("select * from faculty");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

        table=new JTable();
        try{
            conn c=new conn();
            ResultSet resultSet= c.s.executeQuery("select * from faculty");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
                
            }
        
        catch(Exception e){
            System.out.println(e);
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,871,523);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,100,20);                            
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma",Font.BOLD,14));
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(130,70,80,20);                            
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Tahoma",Font.BOLD,14));
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(230,70,100,20);                            
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma",Font.BOLD,14));
        update.addActionListener(this);
        add(update);

        add=new JButton("Add");
        add.setBounds(340,70,80,20);                            
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        add.addActionListener(this);
        add(add);

        cancel=new JButton("Cancel");
        cancel.setBounds(430,70,80,20);                            
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);


    }


    public static void main(String[] args) {
        new facultydetails();
        
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search){

            String query= "select * from student where rollno='"+cempid.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else if (ae.getSource()==print){
            try{

                   table.print();
            }
            catch(Exception e){
                System.out.println(e);

            }

        }
        else if (ae.getSource()==add){
            setVisible(false);
            new newfaculty().setVisible(true);

        }else if(ae.getSource()==update){
            setVisible(false);

        }
        else if (ae.getSource()==cancel){
            setVisible(false);
            new project().setVisible(true);

        }
    }
    
}

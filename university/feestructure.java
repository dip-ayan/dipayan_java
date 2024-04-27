package university;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class feestructure extends JFrame {

    JTable table;

    feestructure(){
        setVisible(true);
        setSize(1000,600);
        setLocation(250,50);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 500, 30);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        table=new JTable();
        try{
            conn c=new conn();
            ResultSet resultSet= c.s.executeQuery("select * from fees");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
                
            }
            catch(Exception e){
                System.out.println(e);
            }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,60,1000,540);
        add(jsp);

    }

    public static void main(String[] args) {

        new feestructure();
        
    }

    
}
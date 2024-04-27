package university;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class examdetails extends JFrame implements ActionListener{

    JTextField search;
    JButton result,back;
    JTable table;

    examdetails()
    {
        setVisible(true);
        setSize(1000,500);
        setLocation(250,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Examination Results");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("serif", Font.PLAIN, 18));
        add(search);

        result = new JButton("Check Result");
        result.setBounds(300, 90, 130, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.setFont(new Font("Tahoma", Font.BOLD, 14));
        result.addActionListener(this);
        add(result);

        back = new JButton("Back");
        back.setBounds(450, 90, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        table=new JTable();
        try{
            conn c=new conn();
            ResultSet resultSet= c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
                
            }
        
        catch(Exception e){
            System.out.println(e);
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,330);
        add(jsp);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }

            
            
        });
    }

    public static void main(String[] args) {
        
        new examdetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==result){
        setVisible(false);
        new marks(search.getText()).setVisible(true);

       }
       else if(ae.getSource()==back){
        setVisible(false);
        new project().setVisible(true);
       }
    }
    
}

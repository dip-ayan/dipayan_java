package university;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class project extends JFrame implements ActionListener{

    project(){
        setVisible(true);
        setSize(871,623);
        setLocation(250,50);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/college.jpg"));
        Image i2= i1.getImage().getScaledInstance(871,613,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
       // image.setBounds(350,0,200,200);
        add(image);

        JMenuBar mb=new JMenuBar();                            //creating menu bar//
        
        JMenu newinfo=new JMenu("New Information");
        newinfo.setForeground(Color.BLUE);
        newinfo.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(newinfo);

        JMenuItem facultyinfo=new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(Color.WHITE);
        facultyinfo.setFont(new Font("Raleway",Font.BOLD,12));
        facultyinfo.addActionListener(this);
        newinfo.add(facultyinfo);

        JMenuItem studentinfo=new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.setFont(new Font("Raleway",Font.BOLD,12));
        studentinfo.addActionListener(this);
        newinfo.add(studentinfo);

        JMenu details=new JMenu("View Details");
        details.setForeground(Color.BLUE);
        details.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(details);

        JMenuItem facultydetails=new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.setFont(new Font("Raleway",Font.BOLD,12));
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails=new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.setFont(new Font("Raleway",Font.BOLD,12));
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        JMenu leave=new JMenu("Leave");
        leave.setForeground(Color.BLUE);
        leave.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(leave);

        JMenuItem facultyleave=new JMenuItem(" Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.setFont(new Font("Raleway",Font.BOLD,12));
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave=new JMenuItem(" Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.setFont(new Font("Raleway",Font.BOLD,12));
        studentleave.addActionListener(this);
        leave.add(studentleave);

        JMenu leavedetails=new JMenu(" Leave Details");
        leavedetails.setForeground(Color.BLUE);
        leavedetails.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(leavedetails);

        JMenuItem facleavedetails=new JMenuItem(" Faculty Leave Details");
        facleavedetails.setBackground(Color.WHITE);
        facleavedetails.setFont(new Font("Raleway",Font.BOLD,12));
        facleavedetails.addActionListener(this);
        leavedetails.add(facleavedetails);

        JMenuItem stuleavedetails=new JMenuItem(" Student Leave Details");
        stuleavedetails.setBackground(Color.WHITE);
        stuleavedetails.setFont(new Font("Raleway",Font.BOLD,12));
        stuleavedetails.addActionListener(this);
        leavedetails.add(stuleavedetails);

        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        exam.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(exam);

        JMenuItem examresults=new JMenuItem("Examination Results");
        examresults.setBackground(Color.WHITE);
        examresults.setFont(new Font("Raleway",Font.BOLD,12));
        examresults.addActionListener(this);
        exam.add(examresults);

        JMenuItem entermarks=new JMenuItem("Enter Student Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.setFont(new Font("Raleway",Font.BOLD,12));
        entermarks.addActionListener(this);
        exam.add(entermarks);

        JMenu update=new JMenu("Update Info");
        update.setForeground(Color.BLUE);
        update.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(update);

        JMenuItem updatefacinfo=new JMenuItem("Update Faculty Information");
        updatefacinfo.setBackground(Color.WHITE);
        updatefacinfo.setFont(new Font("Raleway",Font.BOLD,12));
        updatefacinfo.addActionListener(this);
        update.add(updatefacinfo);

        JMenuItem updatestuinfo=new JMenuItem("Update Student Information");
        updatestuinfo.setBackground(Color.WHITE);
        updatestuinfo.setFont(new Font("Raleway",Font.BOLD,12));
        updatestuinfo.addActionListener(this);
        update.add(updatestuinfo);

        JMenu fees=new JMenu("Fees");
        fees.setForeground(Color.BLUE);
        fees.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(fees);

        JMenuItem feestruc=new JMenuItem("Fees Structure");
        feestruc.setBackground(Color.WHITE);
        feestruc.setFont(new Font("Raleway",Font.BOLD,12));
        feestruc.addActionListener(this);
        fees.add(feestruc);

        JMenuItem feesform=new JMenuItem("Student Fee Form");
        feesform.setBackground(Color.WHITE);
        feesform.setFont(new Font("Raleway",Font.BOLD,12));
        feesform.addActionListener(this);
        fees.add(feesform);

        JMenu about=new JMenu("About Us");
        about.setForeground(Color.BLUE);
        about.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(about);

        JMenuItem ab=new JMenuItem("About Us");
        ab.setBackground(Color.WHITE);
        ab.setFont(new Font("Raleway",Font.BOLD,12));
        ab.addActionListener(this);
        about.add(ab);


        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        exit.setFont(new Font("Raleway",Font.BOLD,12));
        mb.add(exit);

        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.setFont(new Font("Raleway",Font.BOLD,12));
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

    }

    public static void main(String[] args) {
        new project();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg= ae.getActionCommand();
        if (msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("New Faculty Information")){
            setVisible(false);
            new newfaculty().setVisible(true);
        }
        else if(msg.equals("New Student Information")){
            setVisible(false);
            new newstudent().setVisible(true);
        }
        else if(msg.equals("View Faculty Details")){
            setVisible(false);
            new facultydetails().setVisible(true);
        }
        else if(msg.equals("View Student Details")){
            setVisible(false);
            new studentdetails().setVisible(true);
        }
        else if(msg.equals(" Faculty Leave")){
            setVisible(false);
            new facultyleave().setVisible(true);
        }
        else if(msg.equals(" Student Leave")){
            setVisible(false);
            new studentleave().setVisible(true);
        }
        else if(msg.equals(" Faculty Leave Details")){
            setVisible(false);
            new facultyleavedetails().setVisible(true);
        }
        else if(msg.equals(" Student Leave Details")){
            setVisible(false);
            new studentleavedetails().setVisible(true);
        }
        else if(msg.equals("Update Faculty Information")){
            setVisible(false);
            new updatefaculty().setVisible(true);
        }
        else if(msg.equals("Update Student Information")){
            setVisible(false);
            new updatestudent().setVisible(true);
        }
        else if(msg.equals("Enter Student Marks")){
            setVisible(false);
            new entermarks().setVisible(true);
        }
        else if(msg.equals("Examination Results")){
            setVisible(false);
            new examdetails().setVisible(true);
        }
        else if(msg.equals("Fees Structure")){
            setVisible(false);
            new feestructure().setVisible(true);
        }
        else if(msg.equals("Student Fee Form")){
            setVisible(false);
            new feeform().setVisible(true);
        }

        else if(msg.equals("About Us")){
            //String websiteLink = JOptionPane.showInputDialog("https://rpcollege.ind.in/");
            //Runtime.getRuntime().exec("calc.exe");

                // Open the website link in a web browser
                try {
                    Desktop.getDesktop().browse(URI.create("https://rpcollege.ind.in/"));
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }

        }
    }
        
    
}

package university;

import java.awt.*;

import javax.swing.*;

public class splash extends JFrame implements Runnable {
    Thread t;

    splash(){
        setVisible(true);
        setSize(300,300);
        setLocation(550,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/unilogo.jpg"));
        Image i2= i1.getImage().getScaledInstance(223,226,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        add(image);

        t=new Thread(this);
        t.start();

    }
    


public static void main(String args[]){
    new splash();

}



@Override
public void run() {
   
    try{
    Thread.sleep(7000);
    setVisible(false);
    new login();
    }
    catch(Exception e){

    }
}

}

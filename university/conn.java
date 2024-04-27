package university;

import java.sql.*;


public class conn {
    Connection c;
    Statement s;

     public  conn(){

        try{
            
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=universitymanagementsystem;integratedSecurity=true;encrypt=true;trustServerCertificate=true;" ;
            Connection c = DriverManager.getConnection(connectionUrl);
            s=c.createStatement();
            
        

        }
        catch(Exception e){
            System.out.println(e);

        }
    }
}
    


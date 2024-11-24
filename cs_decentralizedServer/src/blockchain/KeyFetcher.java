package blockchain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class KeyFetcher {
    
    public String  getKey()
    {


            String key="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
            Statement st=conn.createStatement();

            String query="Select * from blockchaininfo ";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                
               key=rs.getString(3);
            
            }
          
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return key;
    }
 


}

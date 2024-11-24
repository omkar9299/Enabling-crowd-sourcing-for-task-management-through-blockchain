package cs_provider;

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
    
    public String  getDetails(String uname)
    {
     String key="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
            Statement st=conn.createStatement();
            String query="Select * from providerinfo where username='"+uname+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
             key=rs.getString(7);
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

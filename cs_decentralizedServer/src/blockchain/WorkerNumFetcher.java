package blockchain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import db.DBDriver;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class WorkerNumFetcher {
    
    public String getDetails(String workername)
    {
        System.out.println("workername "+workername);

        String num="";
        
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from workerinfo where username='"+workername+"'";
            ResultSet rs=st.executeQuery(query);
     //name, mobileno, emailid, experience, username, password, balance, sign, rewards, penalty     
            if(rs.next())
            {
               
                num=rs.getString(2);
//         
            }
            
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return num;
    }
 


}

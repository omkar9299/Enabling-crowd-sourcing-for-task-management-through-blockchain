package cs_worker;

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
public class ProviderInfoFetcher {
    
    public String  getProviderInfo(String name)
    {

        String mob="";
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from providerinfo where username='"+name+"'";
            ResultSet rs=st.executeQuery(query);
     //taskid, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status       
            if(rs.next())
            {
              mob=rs.getString(2);
           
            }
         
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return mob;
    }
 


}

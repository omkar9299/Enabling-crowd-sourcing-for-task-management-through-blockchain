package workerupload;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import assigned.*;
import db.DBDriver;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class ContractTaskKeyFetcher {
    
    public String  getKey(String taskid)
    {


            String key="";
        try
        {
             Statement st=new DBDriver().getDriverStatement();

            String query="Select * from assignedinfo where taskid ='"+taskid+"' ";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                
               key=rs.getString(6);
            
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

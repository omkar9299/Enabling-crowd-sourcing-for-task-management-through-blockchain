package submitask;

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
public class ContractKeyFetcher {
    
    public String  getKey(String filename)
    {

//taskid, puname, wuname, assignedfilename, submittedfilename, mkey, assigneddatetime, submitdatetime, rewards, penalty, status
            String key="";
        try
        {
             Statement st=new DBDriver().getDriverStatement();

            String query="Select * from assignedinfo where submittedfilename='"+filename+"' ";
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

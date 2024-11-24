package workerupload;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import cs_worker.*;
import db.DBDriver;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class AssignedProviderzInfoFetcher {
    
    public String  getProviderInfo(String taskid)
    {

        String puname="";
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from assignedinfo where taskid ='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
     //taskid, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status       
            if(rs.next())
            {
              puname=rs.getString(2);
           
            }
         
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return puname;
    }
 


}

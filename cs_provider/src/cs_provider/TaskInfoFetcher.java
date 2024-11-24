package cs_provider;

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
public class TaskInfoFetcher {
    
    public ArrayList getDetails(String taskid)
    {
 
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from taskinfo where taskid='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
             ar.add(rs.getString(4)); 
             ar.add(rs.getString(5));
            }
            
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return ar;
    }
 


}

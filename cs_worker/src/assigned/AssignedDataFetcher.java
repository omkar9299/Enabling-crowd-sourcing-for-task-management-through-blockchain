package assigned;

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
public class AssignedDataFetcher {
    
    public ArrayList getDetails(String taskid)
    {

//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from assignedinfo where taskid='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
     //taskid, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status       
            if(rs.next())
            {
             ar.add(rs.getString(1));    
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(5));
            ar.add(rs.getString(6));
            ar.add(rs.getString(7));   
            ar.add(rs.getString(8));
            ar.add(rs.getString(9));
            ar.add(rs.getString(10));
           
            

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

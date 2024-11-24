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
public class TaskDeadlineFetcher {
    
    public String  getDetails(String taskid)
    {

//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        String deadline="";
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from taskinfo where taskid='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
     //name, mobileno, emailid, experience, username, password, balance, sign, rewards, penalty      
            if(rs.next())
            {
        
            deadline=rs.getString(7);   
            

           
            

            }
            
         
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return deadline;
    }
 


}

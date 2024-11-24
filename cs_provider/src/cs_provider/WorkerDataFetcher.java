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
public class WorkerDataFetcher {
    
    public ArrayList getDetails(String workername)
    {
        System.out.println("workername "+workername);
//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from workerinfo where username='"+workername+"'";
            ResultSet rs=st.executeQuery(query);
     //name, mobileno, emailid, experience, username, password, balance, sign, rewards, penalty     
            if(rs.next())
            {
             ar.add(rs.getString(5)); 
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(9));
            ar.add(rs.getString(10));
             ar.add(rs.getString(1)); 
            
            
           
            

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

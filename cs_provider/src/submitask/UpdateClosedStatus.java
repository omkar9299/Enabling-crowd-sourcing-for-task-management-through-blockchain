/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submitask;

import cs_provider.*;
import db.DBDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class UpdateClosedStatus {
    
     public boolean updateaccessinfo(String taskid)
    {

        boolean flag=true;
        String status="closed";
        try
        {
           Statement st=new DBDriver().getDriverStatement();
           //name, mobileno, emailid, username, password, balance
            String query = "update  accessrequestinfo set status='"+status+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
    
          public boolean updatetaskinfo(String taskid)
    {

        boolean flag=true;
        String status="closed";
        try
        {
           Statement st=new DBDriver().getDriverStatement();
           //name, mobileno, emailid, username, password, balance
            String query = "update  taskinfo set status='"+status+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
     
            public boolean updateassignedinfo(String taskid)
    {

        boolean flag=true;
        String status="closed";
        try
        {
           Statement st=new DBDriver().getDriverStatement();
           //name, mobileno, emailid, username, password, balance
            String query = "update  assignedinfo set status='"+status+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
          
     
}

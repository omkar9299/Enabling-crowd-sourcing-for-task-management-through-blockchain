/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_provider;

import db.DBDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class TaskInfoInsert {
    
     public boolean insertTaskData(String srno,String uname,String key,String tfilename,String tdescription,String numberoftask,String  deadline,String taskamt,String depositamt,String status)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBDriver().getDriverStatement();
            String query = "insert into taskinfo values ('"+srno+"','"+uname+"','"+key+"','"+tfilename+"','"+tdescription+"','"+numberoftask+"','"+deadline+"','"+taskamt+"','"+depositamt+"', '"+status+"')";
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

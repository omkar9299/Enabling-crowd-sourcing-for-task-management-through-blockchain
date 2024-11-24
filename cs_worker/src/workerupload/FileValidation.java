/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workerupload;

import cs_worker.*;
import db.DBDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class FileValidation {
    
     public boolean getFileValidation(String taskid, String workername)
    {
        
        System.out.println(" taskid "+taskid);
        System.out.println(" workername "+workername);
        boolean flag=true;
     
        
        try
        {
            //taskid, puname, wuname, assignedfilename, submittedfilename, mkey, assigneddatetime, submitdatetime, rewards, penalty, status
           Statement st=new DBDriver().getDriverStatement();
            String query = "Select * from assignedinfo where taskid='"+taskid+"' and wuname='"+workername+"' ";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
                
                flag=true;
            
            
            else
                flag=false;

            System.out.println(flag);

        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
    
}

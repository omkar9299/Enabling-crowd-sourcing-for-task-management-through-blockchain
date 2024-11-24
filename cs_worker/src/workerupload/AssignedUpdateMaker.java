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
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class AssignedUpdateMaker {
    
     public boolean updateAssingnedInfo(String taskid,String submittedfilename,String dt)
    {

        System.out.println("Inside AssignedUpdateMaker "+taskid+" submittedfilename "+submittedfilename+" dt "+dt);
        String status="Submitted";
        boolean flag=true;
        try
        {
           Statement st=new DBDriver().getDriverStatement();
 //taskid, puname, wuname, assignedfilename, submittedfilename, mkey, assigneddatetime, submitdatetime, rewards, penalty, status
            String query = "update  assignedinfo set submittedfilename='"+submittedfilename+"', status='"+status+"' , submitdatetime='"+dt+"' where taskid='"+taskid+"'";
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

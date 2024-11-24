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
public class AssignedRewardPenaltyUpdater {
    
     public boolean updateProvider(String rewards,String penalty,String taskid)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBDriver().getDriverStatement();
           //name, mobileno, emailid, username, password, balance
          // name, mobileno, emailid, experience, username, password, balance, sign, rewards, penalty
            String query = "update  assignedinfo set rewards='"+rewards+"', penalty='"+penalty+"' where taskid='"+taskid+"'";
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

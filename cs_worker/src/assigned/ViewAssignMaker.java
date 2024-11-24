/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigned;

import cs_worker.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import db.DBDriver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ViewAssignMaker {
    
    
    public ArrayList getAssignDetails()
    {
        
        ArrayList data=new ArrayList();
        String status="assigned";
        try
        {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
//            Statement st1=(Statement) conn.createStatement();
//            Statement st2=(Statement) conn.createStatement();
            
            Statement st1=(Statement) new DBDriver().getDriverStatement();
           
            String query="Select * from assignedinfo where status='"+status+"' ";

            ResultSet rs1=st1.executeQuery(query);
 //taskid, puname, wuname, filename, mkey, assigneddatetime, submitdatetime, rewards, penalty, status    
            while(rs1.next())
            {
                ArrayList temp=new ArrayList();
                
                String taskid=rs1.getString(1);
                String puname=rs1.getString(2);
                String wuname=rs1.getString(3);
                String filename=rs1.getString(4);
                String mkey=rs1.getString(5);
                String assigneddatetime=rs1.getString(6);
                String submitdatetime=rs1.getString(7);
                String rewards=rs1.getString(8);
                String penalty=rs1.getString(9);
                
                
                temp.add(taskid);
                temp.add(puname);
                temp.add(wuname);
                temp.add(filename);
                temp.add(mkey);
                temp.add(assigneddatetime);
                temp.add(submitdatetime); 
                temp.add(rewards);
                temp.add(penalty);
                
                data.add(temp);
            
            }

          
            System.out.println("datac "+data);
        }
           
        catch(Exception e)
        {
            System.out.println("Exception at DataFetcher"+e);

        }

      //return data;
        return data;
    }    
}

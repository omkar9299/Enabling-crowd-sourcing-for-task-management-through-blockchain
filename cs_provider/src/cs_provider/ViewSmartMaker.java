/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_provider;

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
public class ViewSmartMaker {
    
    
    public ArrayList getAllDetails(String uname)
    {
        System.out.println("login "+uname);
        ArrayList data=new ArrayList();
     
        try
        {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
//            Statement st1=(Statement) conn.createStatement();
//            Statement st2=(Statement) conn.createStatement();
            
            Statement st1=(Statement) new DBDriver().getDriverStatement();
           
//workerusername, taskID, provideruname, datetime, status
            String query="Select * from accessrequestinfo where provideruname='"+uname+"' ";

            ResultSet rs1=st1.executeQuery(query);
     
            while(rs1.next())
            {
                ArrayList temp=new ArrayList();
                
                String workerusername=rs1.getString(1);
                String taskID=rs1.getString(2);
                String provideruname=rs1.getString(3);
                String datetime=rs1.getString(4);
                String status=rs1.getString(5);
             
                System.out.println("provideruname "+provideruname);
                temp.add(workerusername);
                temp.add(taskID);
                temp.add(provideruname);
                temp.add(datetime);
                temp.add(status);
                
                data.add(temp);
            
            }

          
           
        }
           
        catch(Exception e)
        {
            System.out.println("Exception at DataFetcher"+e);

        }

      //return data;
        return data;
    }    
}

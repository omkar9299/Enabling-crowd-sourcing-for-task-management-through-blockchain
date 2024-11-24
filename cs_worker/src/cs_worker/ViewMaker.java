/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_worker;

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
public class ViewMaker {
    
    
    public ArrayList getAllDetails()
    {
        
        ArrayList data=new ArrayList();
        String status="NEW";
        try
        {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
//            Statement st1=(Statement) conn.createStatement();
//            Statement st2=(Statement) conn.createStatement();
            
            Statement st1=(Statement) new DBDriver().getDriverStatement();
           
//srno, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status
            String query="Select * from taskinfo where status='"+status+"' ";

            ResultSet rs1=st1.executeQuery(query);
     
            while(rs1.next())
            {
                ArrayList temp=new ArrayList();
                
                String id=rs1.getString(1);
                String proname=rs1.getString(2);
                String tdes=rs1.getString(5);
                String notask=rs1.getString(6);
                String tdeadline=rs1.getString(7);
                String tamt=rs1.getString(8);
                String sdepo=rs1.getString(9);
                
                temp.add(id);
                temp.add(proname);
                temp.add(tdes);
                temp.add(notask);
                temp.add(tdeadline);
                temp.add(tamt);
                temp.add(sdepo);
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

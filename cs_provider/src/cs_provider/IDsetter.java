/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_provider;

import db.DBDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class IDsetter {
    //bidid, uid, itemname, date, time, itprice, bidamt, itemmagename
    public int getId( )
    {
        int id=0;
        ArrayList <Integer> ids=new  ArrayList <Integer>();
        
        try
        {
       
        Statement st=new DBDriver().getDriverStatement();
            String query="Select *from taskinfo   ";
            ResultSet rs=st.executeQuery(query);
        
            while (rs.next())
            {
               String idd= rs.getString(1);
               int  biid=Integer.parseInt(idd);
               ids.add(biid);
                
            }
            if(ids.size()==0)
            {
                id=1;
            }
            else
            {
                int big=ids.get(0);
                for(int i=0;i<ids.size();i++)
                {
                    int aa=ids.get(i);
                    if(aa>big)
                    {
                        big=aa;
                    }
                }
                id=big+1;
            }
           
        }
        
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            
        }
        return id;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_worker;

import db.DBDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class ProviderUpdateMaker {
    
     public boolean updateProvider(String name,String mobno,String email,String uname,String pass)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBDriver().getDriverStatement();
           //name, mobileno, emailid, username, password, balance
            String query = "update  workerinfo set name='"+name+"', mobileno='"+mobno+"', emailid='"+email+"',password='"+pass+"'where username='"+uname+"'";
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

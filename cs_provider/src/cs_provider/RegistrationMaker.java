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
public class RegistrationMaker {
    
     public boolean registerProvider(String name,String mobno,String email,String uname,String pass, String balance,String sign)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBDriver().getDriverStatement();
            String query = "insert into providerinfo values ('"+name+"','"+mobno+"','"+email+"','"+uname+"','"+pass+"', '"+balance+"', '"+sign+"')";
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

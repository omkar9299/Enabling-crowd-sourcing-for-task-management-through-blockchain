package cs_provider;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class ProDataFetcher {
    
    public ArrayList getDetails(String name)
    {

//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
            Statement st=conn.createStatement();

            String query="Select * from providerinfo where username='"+name+"'";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
//candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname
            ar.add(rs.getString(1));
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(5));
            ar.add(rs.getString(6));
            
           
            

            }
            conn.close();
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return ar;
    }
 


}

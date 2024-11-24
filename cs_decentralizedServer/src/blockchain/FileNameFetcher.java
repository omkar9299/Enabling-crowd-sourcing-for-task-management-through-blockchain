package blockchain;

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
public class FileNameFetcher {
    
    public ArrayList getFileDetails()
    {

//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        ArrayList data= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
            Statement st=conn.createStatement();

            String query="Select * from taskinfo";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
//candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname
                ArrayList nm=new ArrayList();
            nm.add(rs.getString(1));
            nm.add(rs.getString(4));
           
            data.add(nm);
            }
            conn.close();
           
      
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return data;
    }
 


}

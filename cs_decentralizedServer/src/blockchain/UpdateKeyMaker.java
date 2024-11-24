

package blockchain;
import admin.*;
import java.sql.*;


public class UpdateKeyMaker {

     public boolean UpdateKeyInfo(String datetime,String key )
    {
boolean flag=true;
        try
        {
            String type="blockchainterminalkey";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
            Statement st=conn.createStatement();
//        /type, datetime, terminalkey
            String query="update blockchaininfo set  datetime='"+datetime+"' , terminalkey='"+key+"' where type='"+type+"' " ;
            int x=st.executeUpdate(query);
        //aid, username, password  admininfo
            if(x>0)
            {
                flag=true;
            }
            else

            {
                flag=false;
 }
            
                conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in AdminUpdateMaker"+e);
            flag=false;
        }

return flag;

    }

}

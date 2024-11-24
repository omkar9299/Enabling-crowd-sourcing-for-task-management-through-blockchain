

package admin;
import java.sql.*;


public class AdminUpdateMaker {

     public boolean UpdateAdminInfo(String username,String password)
    {
boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainsourcing","root","root");
            Statement st=conn.createStatement();
            
            String query="update admininfo set  password='"+password+"' where username='"+username+"' " ;
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

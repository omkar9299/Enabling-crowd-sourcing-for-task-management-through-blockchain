/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netops;

import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Mohit
 */
public class ServerSender {
    public void sendData(String msg,String ip)
    {
        try
        {
            Socket ss=new Socket(ip,12346);
            OutputStream os= ss.getOutputStream();
            DataOutputStream dos= new DataOutputStream(os);
            

            dos.writeUTF(msg);
            
            
            ss.close();
            os.close();
            dos.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in Sender"+e);
        }
    }
}

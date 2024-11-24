/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netops;

import assigned.ContractKeyFetcher;
import assigned.TextFileWriter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import cipher.Decryptor;
import utility.Datakeeper;


/**
 *
 * @author Mohit
 */
public class ServerReceiver extends Thread{
    public void run()
    {
     String main="";
        
       
        System.out.println("Recevier Starter");
        try
        {
            ServerSocket s= new ServerSocket(12347);
            while(true)
            {
                Socket ss= s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                String ms=dis.readUTF();
                System.out.println("Worker Receiver "+ms);
                
                
                
                
                
                
                   File folder = new File(Datakeeper.dpath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                    String mm[] = ms.split("#");
                    String filename = mm[1];
                    String con = mm[2];
                    
                    String ckey=new ContractKeyFetcher().getKey(filename);
                    
                    
                    String dcrycon=new Decryptor().startDecryption(con, ckey);
                    
                    String p = Datakeeper.dpath + "//" + filename;
                  System.out.println("Download path "+p);
                    TextFileWriter tfw = new TextFileWriter();
                    if (tfw.getContent(p, dcrycon)) {
                        
                       
                          Datakeeper.server_rec_string="File Downloaded";
                        System.out.println(filename + " File Downloaded Suucessfully");

                    } else {
                        System.out.println(" Error in downloading " + filename);
                    }

     }
            }
        
        catch(Exception e)
        {

        }
       
    }
}

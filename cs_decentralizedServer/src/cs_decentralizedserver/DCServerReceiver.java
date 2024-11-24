/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_decentralizedserver;

import blockchain.Blockchain;
import blockchain.BlockchainAlpha;
import blockchain.BlockchainUpdator;
import blockchain.CurrentTime;
import blockchain.FileNameFetcher;
import blockchain.Sorter;
import blockchain.TextFileReader;
import blockchain.UpdateKeyMaker;
import blockchain.WorkerNumFetcher;
import blockchain.sendSMS;
import db.AssignedInserter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextArea;
import keygeneration.CurrentDate;
import keygeneration.KeyGenSupporter;
import keygeneration.MD5;
import cipher.Decryptor;
import cipher.Encryptor;
import util.Datakeeper;
import static util.Datakeeper.path;

/**
 *
 * @author Mohit
 */
public class DCServerReceiver extends Thread {

    public void run() {
        String main = "";
        String finmsg="";
        
        
         ArrayList asfileinfo=new  ArrayList();
        System.out.println("Recevier Starter");
        try {
            ServerSocket s = new ServerSocket(1254);
            while (true) {
                Socket ss = s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String ms = dis.readUTF();
                
                if(ms.startsWith("upload"))
                {

                File folder = new File(Datakeeper.path);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                File lf[] = folder.listFiles();

                if (lf.length == 0) {
                    String mm[] = ms.split("111");
                    String filename = mm[1];
                    String str = mm[2];
                    System.out.println("Received file name is " + filename);
                    /// System.out.println("str is "+str);
                    String p = Datakeeper.path + "//" + filename;
                    //String p="D:/File Server";
                    TextFileWriter tfw = new TextFileWriter();
                    if (tfw.getContent(p, str)) {
                        System.out.println(filename + " is stored Successfully");

                    } else {
                        System.out.println(" Error in soring " + filename);
                    }

                    String content = new TextFileReader().getContent(p);
                    String hashkey = new MD5().MDfive(content);
                    String key = new KeyGenSupporter().getKey(hashkey);

                    String date = new CurrentDate().getDate();
                    String time = new CurrentTime().getTime();
                    String dt = date + "-" + time;

                    UpdateKeyMaker um = new UpdateKeyMaker();
                    if (um.UpdateKeyInfo(dt, key)) {
                        //  JOptionPane.showMessageDialog(null, "Key Updated Sucessfully");
                    }

                    String msg = "stored safely";
                    DCServerSender sers = new DCServerSender();
                    sers.sendData(msg, Datakeeper.providerip);

                    System.out.println("Message Sent to Provider " + msg);
                    
                    String tx= finmsg+"\n"+msg+filename;
                    
                    StartServer.jTextArea1.setText(tx);

                } else {

                    ArrayList fileinfo = new FileNameFetcher().getFileDetails();
                     asfileinfo = new Sorter().getSortedList(fileinfo);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println(asfileinfo);

                    Blockchain bc = new Blockchain();
                    String filename="";
                    if (bc.createBlockchain(asfileinfo)) 
                    {

                        String mm[] = ms.split("111");
                         filename = mm[1];
                        String str = mm[2];
                        System.out.println("Received file name is " + filename);
                        /// System.out.println("str is "+str);
                        String newpath = Datakeeper.path + "//" + filename;
                        //String p="D:/File Server";
                        TextFileWriter tfw = new TextFileWriter();
                        if (tfw.getContent(newpath, str)) 
                        {
                            System.out.println(filename + " is stored Successfully");

                        } else 
                        {
                            System.out.println(" Error in   " + filename);
                        }

                        new BlockchainAlpha().createBlockchain(asfileinfo, newpath);
                        

                        String msg = "stored safely";
                        DCServerSender sers = new DCServerSender();
                        sers.sendData(msg, Datakeeper.providerip);

                        System.out.println("Message Sent to Provider " + msg);
                        
                        String tx= finmsg+"\n"+msg+filename;
                        
                        StartServer.jTextArea1.setText(tx);

                    } else
                    {
                        String msg = "not stored and Data is unsafe";
                        DCServerSender sers = new DCServerSender();
                        sers.sendData(msg, Datakeeper.providerip);

                        System.out.println("Message Sent to Provider " + msg);
                        
                        String tx= finmsg+"\n"+msg+filename;
                        StartServer.jTextArea1.setText(tx);
                        
                    }

                }
                }
                
                else if(ms.startsWith("smartcontract"))
                {
                    
                    System.out.println("Welcome to smart Contract");
                    
                    String mm[] = ms.split("#");
                    
                    String taskid=mm[1];
                    String filename=mm[2];
                    String puname=mm[3];
                    String wuname=mm[4];
                    String psign=mm[5];
                    String wsign=mm[6];
                    
                    System.out.println("Task id "+taskid+" File name "+filename+" puname "+puname+" wuname "+wuname+" psign "+psign+" wsign "+wsign);
                    
                     String newpath = Datakeeper.path + "//" + filename;
                     String content=new TextFileReader().getContent(newpath);
                      String findcr=new Decryptor().startDecryption(content, psign);
                      
                     TextFileWriter tfw = new TextFileWriter();
                        if (tfw.getContent(newpath, findcr)) 
                        {
                            System.out.println(filename + "Decrypted  Successfully");

                        } else 
                        {
                            System.out.println(" Error in   " + filename);
                        }
                    String newcontent=new TextFileReader().getContent(newpath);
                    
                    String mkey=psign+wsign;
                    String hashkey=new MD5().MDfive(mkey);
                    String finmkey =new KeyGenSupporter().getKey(hashkey);
                    
                    
                    
                    String finenc=new Encryptor().startEncryption(newcontent, finmkey);
                    
                    
                        if (tfw.getContent(newpath, finenc)) 
                        {
                            System.out.println(filename + " Encrypted By Mutual Sign Successfully");

                        } else 
                        {
                            System.out.println(" Error in   " + filename);
                        }
                        
                         ArrayList fileinfo = new FileNameFetcher().getFileDetails();
                     ArrayList aasfileinfo = new Sorter().getSortedList(fileinfo);
                     
                          new BlockchainUpdator().createBlockchain(aasfileinfo);
                        System.out.println("updating done");
                        
                           String dt=new CurrentDate().getDate();
                           
                           System.out.println("Current Date "+dt);
                    String sdt="empty";
                    String reward="0";
                    String pen="0";
                    String status="assigned";
                    String submitfilename="empty";
                    System.out.println("+_+_++_+_+_+_+_+_+_+_+_+_+_+_");
              AssignedInserter ass=    new AssignedInserter();
              if(ass.registerAssignedinfo(taskid, puname, wuname, filename,submitfilename, finmkey, dt, sdt, reward, pen, status))
                      {
                          
                         // JOptionPane.showMessageDialog(null,"Task has been Assigned");
                          
                          
                      }
              else
              {
                  System.out.println("error");
              }
                          
                          
                          
                          
                          
                    String wnum=new WorkerNumFetcher().getDetails(wuname);
                    String message="Dear, "+wuname+" your request has been granted for the new job by the provider "+puname+" for task id "+taskid+" ,please Access it.";
                   
                    
                    
                   
                      System.out.println("&&&&&&  "+wnum);
                   
                    
                    new sendSMS().sendText(message, wnum);
                    
                }
                else if(ms.startsWith("downloadsubmittedfile"))
                {
                    //downloadsubmittedfile
                    
                    
                    System.out.println(" Inised downloadsubmittedfile ");
                     String mm[] = ms.split("#");
                    
                     System.out.println(" Inser DSSS "+ms);
                     
                    String filname=mm[1];
                    String newpath = Datakeeper.submitpath + "//" + filname;
                    String content=new TextFileReader().getContent(newpath);
                   String str="submit";
                   
                   String mainstr=str+"#"+filname+"#"+content;
                    System.out.println("sssssssssssssssssssssss "+mainstr);
                    
                    DCServerSender d=new DCServerSender();
                    d.sendData(mainstr, Datakeeper.providerip);
                   
                    
                    
                    
                    
                    
                    
                    
                }
                
                
                
                
                
//                  RecvFrame.fname=filename;
//                  RecvFrame.con=str;
//             DCServerSender serv= new DCServerSender();
//             serv.sendData(concat, DataKeeper.ip);
//             SearchResultFrame.concat=concat;
//             SearchResultFrame mf = new SearchResultFrame();
//             Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//             mf.setVisible(true);
//             mf.setSize(d);
            }
        } catch (Exception e) {

        }

    }
}

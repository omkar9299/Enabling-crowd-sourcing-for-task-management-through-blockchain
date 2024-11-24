/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workerserver;

import cs_decentralizedserver.*;
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
public class WorkerServerReceiver extends Thread {

    public void run() {
        String main = "";
        String finmsg="";
        
        
         ArrayList asfileinfo=new  ArrayList();
        System.out.println("Recevier Starter");
        try {
            ServerSocket s = new ServerSocket(12346);
            while (true) {
                Socket ss = s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String ms = dis.readUTF();
                
                 if(ms.startsWith("download"))
                {
                     String mm[] = ms.split("#");
                    
                    String filname=mm[1];
                    
                    System.out.println("Filename WorkerServerReceiver "+filname);
                    String newpath = Datakeeper.path + "//" + filname;
                    String content=new TextFileReader().getContent(newpath);
                    String str="file";
                    String mainstr=str+"#"+filname+"#"+content;
                    
                    WorkerServerSender wss=new WorkerServerSender();
                    wss.sendData(mainstr, Datakeeper.workerip);
                    
                    
                    
                }
                 else if(ms.startsWith("submit"))
                 {
                            File folder = new File(Datakeeper.submitpath);
                      if (!folder.exists()) {
                          folder.mkdirs();
                      }

                     
                     
                     String mm[] = ms.split("#");
                     String filename=mm[1];
                     String con=mm[2];
                     String newpath = Datakeeper.submitpath + "//" + filename;
                     TextFileWriter tf=new TextFileWriter();
                     tf.getContent(newpath, con);
                     
                    // JOptionPane.showMessageDialog(null, "File Received Successfully from Worker");
                     
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

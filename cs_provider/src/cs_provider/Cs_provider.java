/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs_provider;

import java.awt.Dimension;
import java.awt.Toolkit;
import netops.ServerReceiver;

/**
 *
 * @author 2491
 */
public class Cs_provider {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            
        ServerReceiver sr=new ServerReceiver();
        sr.start();
        
                   ProLoginFrame plog=new ProLoginFrame();
        plog.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        plog.setSize(d);
    
        

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs_worker;

import java.awt.Dimension;
import java.awt.Toolkit;
import netops.ServerReceiver;

/**
 *
 * @author 2491
 */
public class Cs_worker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ServerReceiver().start();
        WoLoginFrame plog=new WoLoginFrame();
        plog.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        plog.setSize(d);
        
    }
    
}

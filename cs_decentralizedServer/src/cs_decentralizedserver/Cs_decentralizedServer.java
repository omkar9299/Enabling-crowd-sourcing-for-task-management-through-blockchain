/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs_decentralizedserver;

import admin.LoginFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author 2491
 */
public class Cs_decentralizedServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            LoginFrame l = new LoginFrame();
            l.setSize(d);
           
            l.setVisible(true);
        
  
    }
    
}

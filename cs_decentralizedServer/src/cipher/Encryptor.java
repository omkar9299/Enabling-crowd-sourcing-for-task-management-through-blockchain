/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cipher;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Encryptor 
{
    
   public String startEncryption(String ms,String key)
   {
       
       
        Divider d=new Divider();
        ArrayList mas=d.divideString(ms);



String ens="";
for(int i=0;i<mas.size();i++)
{
int n=i+1;



String str=(String)mas.get(i);
 Rotate     rr=new Rotate();
 String str1=rr.rotateString(str, n);

 //System.out.println("Rotated String is "+str1);


 Encryption   re=new Encryption();
 String estr=re.getReverseEn(str1,key);



 ens=ens+estr;
        }

       
     return ens;  
   }    
}

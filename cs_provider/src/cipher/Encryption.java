/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cipher;

/**
 *
 * @author Dilip
 */
public class Encryption

{

    public String getReverseEn(String str,String key)
    {
        int sum=0;
        //64E049
        for(int i=0;i<key.length();i++)
        {
            
            char ch=key.charAt(i);
           int alpha=(int)ch;
           sum=sum+alpha;
            
            
        }
       // System.out.println("SUM IS E  "+sum);
        int value=sum%20;
        
         PrimeKey rs=new PrimeKey();
        value= rs.getkey(value);
        
        
String res = "";

        char ch[]=str.toCharArray();

        String pp="";

        for(int i=0;i<ch.length;i++)
        {

            char c=ch[i];
            int y=c;

         
           
              int a=y;
       if(a<161)
       {

      
        int f=a+(161+value);  //171   162

     
        char chh=(char)f;

        String pr=Character.toString(chh);
        pp=pp+pr;
       }
                         
        }

        res=pp;

        

        



        return res;
    }

}

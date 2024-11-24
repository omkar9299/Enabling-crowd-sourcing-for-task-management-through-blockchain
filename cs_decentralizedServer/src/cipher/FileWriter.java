/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cipher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Dilip
 */
public class FileWriter
{

    public boolean createFile(String str,String path) throws FileNotFoundException
    {
boolean val=false;

         try
   {
    FileOutputStream f2=new FileOutputStream(path);

     for(int i=0;i<str.length();i++)
     {
       char ch=str.charAt(i);
       int y=(int)ch;
       f2.write(y);

     }
     f2.close();
     val=true;

    }
         catch(Exception e) {}

return val;
    }
}

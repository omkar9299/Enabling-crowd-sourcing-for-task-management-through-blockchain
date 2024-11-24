/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cipher;

/**
 *
 * @author 2491
 */
public class PrimeKey {
    
    public int getkey(int x)
    {
        
        int n=20;
        int count=0;
        int prime[]=new int[n];
        int i=3;
        int index=0;
        while(count!=n)
        {
            boolean flag=true;    
            for (int j = 2; j <i; j++) 
            {
            
                if(i%j==0)
                {
                    flag=false;
                    break;
                }
                  
            }
             if(flag)
                {
                    
                   prime[index++]=i;
                 //   System.out.println(i);
                    count++;
            
                 }
             i++;
        }
        System.out.println("Prime Numbers are ");
        for (int j = 0; j < prime.length; j++)
        {
        
            System.out.println(prime[j]);
            
        }
        
        
        int key=prime[x];
        
        
        
        
        
        
        
        
      return key;  
    }
    
    
    
}

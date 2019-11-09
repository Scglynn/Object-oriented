import java.util.*;
import java.io.*;

public class PrimeSieve{
    public static void main(String[] args){

        int n = Integer.parseInt(args[0]);

        boolean prime[] = new boolean[n+1]; 
        for(int i=2;i<=n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
             
            if(prime[p] == true) 
            { 
             
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
         int count = 0; 
        
        for(int i = 1; i <= n; i++) 
        { 
            if(prime[i] == true) 
                count++;
        } 

    System.out.println("There are " + count + " primes less than or equal to " + n + ".");
    }
}
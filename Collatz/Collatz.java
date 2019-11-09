import java.io.*;
import java.util.*;

public class Collatz{

    public static void main(String[] args)
    {
        int i=0;
        int j=0;
        
        int count = 1;
        int totalcount = 0;

        i =Integer.parseInt(args[0]);
        j = Integer.parseInt(args[1]); 
        int x = 0;
        for (int y = i; y <= j; y++){
            count = 1;
            x = y;
            while (x > 1)
            {
                if (x % 2 == 0)
                {
                    x = x/2;
                
                } else {
                    x = (3 * x) + 1;
                
                }
                count++;

            }
            if (count > totalcount){
                totalcount = count;

            }
        }

        System.out.println("Maximum sequence length between " + i + " and " + j + " is " + totalcount + ".");
    }

}
import java.io.*;
import java.lang.Math;


public class DayOfWeek {
    public static void main(String [] args) 
    {

       int m = Integer.parseInt(args[0]);

        int d = Integer.parseInt(args[1]);

        int y = Integer.parseInt(args[2]);

        y = y - ((14 - m) / 12);

        int x = y + (y / 4) - (y / 100) + (y / 400); 

        m = m + (12 * ((14 - m) / 12) ) - 2;


        int outDay = ((d + x + ((31 * m) / 12)) % 7);

       

        System.out.println(args[0] + "/" + args[1] + "/"+ args[2] + " falls on " + outDay + ".");
    }
}


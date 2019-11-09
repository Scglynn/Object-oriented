import java.io.*;
import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {


        int rows = 0;
        
        rows = Integer.parseInt(args[0]);


        for(int i = 0; i < rows; i++) {
               
        int number = 1;
            try {
                System.out.format("%" + ((rows - i) * 3 - 3) + "s","");

            } catch (Exception e) {}

            for(int j = 0; j <= i; j++) {

             

                 System.out.format("%6d",number);

                 number = number * (i - j) / (j + 1);
                 
            }
            System.out.println();
        }
    }
}
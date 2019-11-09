import java.io.*;
import java.util.Scanner;

public class PatternPyramid{

   
    public static void main(String[] args) {

        int i,j,k,number;
        Scanner user_input;

        user_input = new Scanner (System.in);
       number = Integer.parseInt(args[0]);

        for(i = 1; i <= number; i++)
        {
            for(j = i; j <number;j++)
            {
                System.out.print(" ");
            }
            for(k = 1; k < (i * 2); k++)
            {
                System.out.print("*");
            }
            for(j = i; j <number;j++)
            {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        user_input.close();
    }
}
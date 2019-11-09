import java.util.Scanner;
import java.util.*;
import java.io.*;

public class LetterFlip { 
    public static void main(String[] args) throws IOException {
        String x;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) 
        {

        x = sc.nextLine();

        char[] ch = x.toCharArray();
        for(int i=0;i < ch.length; i++)
        {
            if (Character.isLowerCase(ch[i])) {

                ch[i] = Character.toUpperCase(ch[i]);
                
            } 

            else {
                ch[i] = Character.toLowerCase(ch[i]);
            }
            
        }
        String out = new String(ch);
        System.out.println(out);
    }
        
    }
}
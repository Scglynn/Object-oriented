import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Matrix{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = 0;
        int row2 = 0;
        int col = 0;
        int col2 = 0;
        
        row = scan.nextInt();
        col = scan.nextInt();

        float [][] firstMatrix = new float [row][col];
        
        System.out.println();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                firstMatrix[i][j]= scan.nextFloat();
            }
        }

        row2 = scan.nextInt();
        col2 = scan.nextInt();
        
        float [][] secondMatrix = new float [row2][col2];

        for (int k = 0; k < row2; k++) {
            for (int n = 0; n < col2; n++) {
                secondMatrix[k][n]=scan.nextFloat();
            }
            
        }
        
        if (col == row2) {

            int calcsToMake = row*col2; 
            float [] productMatrix = new float [calcsToMake];
            int ctr=0;

            for (int p = 0; p<row;p++) 
            {
                for (int i = 0; i < col2; i++) 
                { 
                    float val = 0; 
                    for (int j = 0; j < col; j++)
                    {
                        val += firstMatrix[p][j] * secondMatrix[j][i];
                    }
                    productMatrix[ctr]=val;
                    ctr++; 
                }
            }
            
            int count = 0;
            for(int i = 0; i < calcsToMake;i++) {
                System.out.printf("%8.2f", productMatrix[i]);
                count++;
                if(count==col2) 
                {
                    System.out.println();
                    count = 0;
                }
                
            }
        } else {
            System.out.println("incompatible dimensions");
        }
    }
}
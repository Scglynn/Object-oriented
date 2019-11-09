import java.util.*;
import java.util.Scanner;

public class Distinct
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int nums[] = new int[1000];

        boolean found = false;
        boolean notDone = true;
        int unique[] = new int[0];
        int ctr = 0;

        while(notDone)
        {
            nums[ctr] = scan.nextInt();

            if(nums[ctr] == -1) { 
                notDone = false; 
            } else {
                found = false;
                if(unique.length == 0)
                {
                    unique = Arrays.copyOf(unique, 1);
                    found = true;
                    unique[0] = nums[ctr];
                }
                else
                {
                    for(int i = 0; i < unique.length; i++)
                    {
                        if(unique[i] == nums[ctr])
                        {
                            found = true;
                        }
                    }   
                
                    if(!found)
                    {
                        int len = unique.length + 1;
                        unique = Arrays.copyOf(unique, len);
                        unique[len-1] = nums[ctr];
                        found = false;
                    }
                }
                ctr++;
            }
        }
        for(int p = 0;p<unique.length;p++) {
            System.out.printf("%3d", unique[p]);
        }
    }

}
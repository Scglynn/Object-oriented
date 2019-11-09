//import java.Math;
import java.lang.Math;
import java.io.*;

public class Discriminant {
    public static void main(String[] args) throws IOException
    {
       // BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        

        double b = Double.parseDouble(args[0]); 
        double c = Double.parseDouble(args[1]); 
        double d = Double.parseDouble(args[2]);
        double discriminant = Math.pow(b,2) * Math.pow(c,2) - 4 * Math.pow(c, 3) - 4 * Math.pow(b,3) * d - 27 * Math.pow(d,2) + 18 * b * c *d;

        System.out.printf("The discriminant of the polynomial x^3 + -100.00x^2 + -2.50x + 90.00 " + "is %2.2f.", discriminant);

    }
}

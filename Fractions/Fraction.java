
public class Fraction {
    private final int whole;
    private final int numerator;
    private final int denominator;

    public Fraction(int whole, int numerator, int denominator) {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator) {
        this.whole = 0;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int whole) {
        this.whole = whole;
        this.numerator = 0;
        this.denominator = 0;
    }

    public Fraction() {
        this.whole = 0;
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(Fraction other) {
        whole = other.whole;
        numerator = other.numerator;
        denominator = other.denominator;
    }
    
    private int[] simplify() {
        int[] ret = new int[3];
        ret[0] = whole;
        ret[1] = numerator;
        ret[2] = denominator;

        while (ret[1] >= ret[2]) {

            if (ret[1] > ret[2]) {

                ret[1] = ret[1] - ret[2];
                ret[0] = ret[0] + 1;
            } else {
               ret[0] = ret[0] + 1; 
               ret[1] = 0;
               ret[2] = 0;
               break;
            }            
        }
        return ret;
    }

    // greatest common divisor
    // private int gcd(int a, int b) {
    //     if (b == 0)
    //         return a;
    //     return gcd(b,a%b);
    // }
    
    public Fraction add(Fraction other) {
        int n = (numerator*other.denominator) + (other.numerator*denominator);
        int d = (denominator*other.denominator);
        Fraction result = new Fraction(whole , n, d);
        return result;

    }

    public Fraction subtract(Fraction other) {
        Fraction result = new Fraction(whole, (numerator*other.denominator) - (other.numerator*denominator), (denominator*other.denominator));
        return result;
    }

    public Fraction multiply(Fraction other) {
        int n = numerator;
        int d = denominator;
        int w = whole;
        if(whole > 0) {
            n = (d * whole) + n;
            w = 0;
        }
        Fraction result = new Fraction(w, n * other.numerator, d * other.denominator);
        return result;
    }

    public Fraction divide(Fraction other) {
        int n = numerator;
        int d = denominator;
        int w = whole;
        if(whole > 0) {
            n = (d * whole) + n;
            w = 0;
        }
        Fraction result = new Fraction(w, n*other.denominator, d*other.numerator);
        return result;
    }

    // Return a string representing the reduced fraction. In general a whole number, 
    // a space, the numerator, a slash (/), and a denominator (e.g: 2 3/4). However, 
    // do not include "useless" components, for example all the following are correct 
    // results: "0" (instead of "0 0/8"), "3" (instead of "3 0/2"), "1/3" (instead of "0 2/6"). 
    public String toString() {
        int[] newVals = simplify();
        // if (whole == 0) {
        //     return " " + numerator + "/" + denominator;
        // }
        // if (numerator == 0 || numerator == denominator) {
        //     return whole + " ";
        // }

        // return this.whole + " " + numerator + "/" + denominator;
        
        if (newVals[0] == 0) {
            return " " + newVals[1] + "/" + newVals[2];
        }
        if (newVals[1] == 0 || newVals[1] == newVals[2]) {
            return newVals[0] + " ";
        }

        return newVals[0] + " " + newVals[1] + "/" + newVals[2];
    }
    

    // determine if this Fraction equals other Fraction
    public Boolean equals(Fraction other) {
        if(this.whole== other.whole) 
            if (this.numerator == other.numerator) 
                if (this.denominator == other.denominator) 
                    return true;        
        return false;
    }
    public static void main(String[] args)
    {
        Fraction X = new Fraction(0, 9, 4);
        Fraction Y = new Fraction(0, 8, 5);
        Fraction Z = X.subtract(Y);
        assert Z.toString().equals("13/20"): "Z.toString() == \"13/20\"";
    }
}
public class Fraction {
    private int whole;
    private int numerator;
    private int denominator;

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
    public Fraction(Fraction other){
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
        int d = gcd(ret[1],ret[2]);
        if (d > 0) {
            ret[1] = ret[1]/d;
            ret[2] = ret[2]/d;
        }
        return ret;
    }
    //greatest common divisor
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b,a%b);
    }
 
    public Fraction add(Fraction other) {
        int num1 = 0;
        int denom1 = 0;
        int num2 = 0;
        int num3 = 0;
        int denom2 = 0;

        if (whole > 0) {
            num1 = (whole * denominator) + numerator;
            denom1 = denominator;
            if(denom1 == denom2) {
                num1 = num1 + other.numerator;
            }
        } else {
            num1 = numerator;
            denom1 = denominator;
        }
        if (other.whole > 0) {
            num3 = (other.whole * other.denominator) + other.numerator;
            denom2 = other.denominator;

        } else {
            num3 = other.numerator;
            denom2 = other.denominator;
            
        }
        if (denom1 != denom2) {
            num1 = (num1 * denom2);
            denom1 = (denom1 * denom2);
            num2 = (num3 * denominator);
            num1 = num1 + num2;
        }else {
            num1 = num1 + other.numerator;
            num3 = num3 + this.numerator;
        }
        int n = num1;
        int d = denom1;
        Fraction result = new Fraction(n,d);
        return result;
    
    }
// 1/2 and 1/4 (1/2)4 = 4/8 (1/4)2=2/8
    public Fraction subtract(Fraction other) {
        int num1 = 0;
        int denom1 = 0;
        int num2 = 0;
        int num3 = 0;
        int denom2 = 0;

        if (whole > 0) {
            num1 = (whole * denominator) + numerator;
            denom1 = denominator;
            if(denom1 == denom2) {
                num1 = num1 - other.numerator;
            }
        } else {
            num1 = numerator;
            denom1 = denominator;
        }
        if (other.whole > 0) {
            num3 = (other.whole * other.denominator) + other.numerator;
            denom2 = other.denominator;

        } else {
            num3 = other.numerator;
            denom2 = other.denominator;
            
        }
        if (denom1 != denom2) {
            num1 = (num1 * denom2);
            denom1 = (denom1 * denom2);
            num2 = (num3 * denominator);
            num1 = num1 - num2;
        }else {
            num1 = num1 - other.numerator;
            num3 = num3 - this.numerator;
        }
        int n = num1;
        int d = denom1;
        Fraction result = new Fraction(n,d);
        return result;
    }

    public Fraction multiply(Fraction other) {
        int num1 = 0;
        int denom1 = 0;
        int num2 = 0;
        int denom2 = 0;

        if (whole > 0) {
            num1 = (whole * denominator) + numerator;
            denom1 = denominator;
        } else {
            num1 = numerator;
            denom1 = denominator;
        }

        if (other.whole > 0) {
            num2 = (other.whole * other.denominator) + other.numerator;
            denom2 = other.denominator;

        } else {
            num2 = other.numerator;
            denom2 = other.denominator;
        }
        int n = num1 * num2;
        int d = denom1 * denom2;

        Fraction result = new Fraction(n,d);
        return result;

    }

    public Fraction divide(Fraction other) {
        int num1 = 0;
        int num2 = 0;
        int denom1 = 0;
        int denom2 = 0;


        if (whole > 0) {
            num1 = (whole * denominator) + numerator;
            denom1 = denominator;
        } else {
            num1 = numerator;
            denom1 = denominator;
        }

        if (other.whole > 0) {
            num2 = (other.whole * other.denominator) + other.numerator;
            denom2 = other.denominator;

        } else {
            num2 = other.numerator;
            denom2 = other.denominator;
        }

        int n = num1 * denom2;
        int d = denom1 * num2;

        Fraction result = new Fraction(n,d);
        return result;
    }
    // Return a string representing the reduced fraction. In general a whole number, 
    // a space, the numerator, a slash (/), and a denominator (e.g: 2 3/4). However, 
    // do not include "useless" components, for example all the following are correct 
    // results: "0" (instead of "0 0/8"), "3" (instead of "3 0/2"), "1/3" (instead of "0 2/6"). 

    public String toString() {
        int[] newVals = simplify();

        if (newVals[0] == 0) {
            return "" + newVals[1] + "/" + newVals[2];
        }
        if (newVals[1] == 0 || newVals[1] == newVals[2]) {
            return newVals[0] + "";
        }
        if (newVals[1] < 0 ) {
            return newVals[0] + " " + newVals[1] + "/" + newVals[2];
        }

        return newVals[0] + " " + newVals[1] + "/" + newVals[2];
    }
    // determine if this Fraction equals other Fraction

    public boolean equals(Fraction other) {
        int[] newVals = simplify();
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        if(newVals[0] != other.whole) {
            return false;
        }
        if (newVals[1] != other.numerator) {
            return false;
        }
        if (newVals[2] != other.denominator) {
            return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Fraction X = new Fraction(10, 30, 31);
        Fraction Y = new Fraction(20, 1, 2);
        Fraction Z = X.subtract(Y);
        assert Z.toString().equals("-9 33/62"): "Z.toString() == \"-9 33/62\"";
    }
}
public class Sample {
    public static void main(String[] args) {
        Fraction X = new Fraction(3,3,2);
        System.out.println("X: " + X);
        Fraction Y = new Fraction(0,1,2);
        System.out.println("Y: " + Y);

        Fraction A = X.add(Y);
        System.out.println("ADD: " +  A);

        Fraction S = X.subtract(Y);
        System.out.println("SUB: " +  S);

        Fraction M = X.multiply(Y);
        System.out.println("MUL: " +  M);

        Fraction D = X.divide(Y);
        System.out.println("DIV: " +  D);

        System.out.println("equal? " + X.equals(new Fraction(4,1,2)));
    }
}
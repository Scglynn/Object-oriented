public class Test {
    public static void main(String[] args)
    {
        Fraction x = new Fraction(0, 9, 3);
        Fraction y = new Fraction(2, 1, 4);
        assert !x.equals(y) : "x.equals(y) == false";
    }
}
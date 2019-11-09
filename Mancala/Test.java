public class Test {
    public static void main(String[] args)
    {
        Mancala m = new Mancala();
        assert m.toString().equals(" 0 |  4  4  4  4  4  4 |  *\n - |  4  4  4  4  4  4 |  0\n") : m;
    }
}
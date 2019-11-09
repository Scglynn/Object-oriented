import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {
                Choose c = new Choose();
        Scanner s = new Scanner("2 H 5 6 1 2 @ 2");
        c.read(s);
        assert c.getSize()==2;
        assert c.getPlayer()=='H';
        assert c.getScore('H')==5;
        assert c.getScore('V')==6;
        assert c.getSelectionRow()==1;
        assert c.getSelectionCol()==0;
        assert c.getValue(0,0)==1;
        assert c.getValue(0,1)==2;
    }
}
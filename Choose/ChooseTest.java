import java.util.Scanner;


public class ChooseTest {
    public static void main(String[] args) {
        Choose g = new Choose();
        Scanner s = new Scanner("7 H 0 0 1 2 2 2 2 3 3 3 @ 1 2 2 2");
        g.read(s);

         System.out.printf("size:%d, player:%c\n",g.getSize(),g.getPlayer());
         System.out.printf("score: %d to %d\n",g.getScore('H'),g.getScore('V'));
         System.out.printf("selection: %d,%d\n",g.getSelectionRow(),g.getSelectionCol());

        for (int r=0; r<3; r++)
            for (int c=0; c<3; c++)
                System.out.print(g.getValue(r,c)+" ");
        System.out.println("\n");

        System.out.println(g);
        g.move(0);
        System.out.println(g);
        g.move(2);
        System.out.println(g);
    }
}
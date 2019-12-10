public class MancalaTest {
    public static void main(String[] args) {

        int[] pits = {2,3,4,5,6,7,8,9,10,11,12,13};
        //int[] pits = {5,5,5,5,0,4,4,4,0,5,5,5};

        Mancala g = new Mancala(0, pits, 1, 0);
        System.out.println(g);

         g.move(4);
         System.out.println(g);

         g.move(3);
         System.out.println(g);

         g.move(3);
         System.out.println(g);

         System.out.printf("player: %d\n",g.getPlayer());
         System.out.printf("score: %d to %d\n",g.getScore(0),g.getScore(1));
    }
}
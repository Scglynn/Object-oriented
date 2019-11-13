public class MancalaTest3 {
    public static void main(String[] args) {
        Mancala3 g = new Mancala3
        ();
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

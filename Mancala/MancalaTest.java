public class MancalaTest {
    public static void main(String[] args) {
        Mancala g = new Mancala();
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

import java.util.*;

public class Mancala {

    private int [][] gameBoard;
    private int row = 2;
    private int col = 6;
    public int score= 0;
    public int score2 = 0;
    public int player0 = 0;
    public int player1 = 0;

    public Mancala() {
            gameBoard = new int [row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    gameBoard[i][j] = 4;
                }
            }
        }

    public String toString() {
        String ret = "";
        ret = ret + String.format("%3s",score2 + " |");
        for(int i = 0; i < 6; i++) {
            ret = ret + String.format("%3d", gameBoard[0][i]);
        }
        ret = ret + String.format("%3s", " |  *");

        ret = ret+"\r\n";
        ret = ret + String.format("%3s", "- |");
        for (int i = 0; i < 6; i++) {
            
            ret = ret + String.format("%3d", gameBoard[1][i]);
        }
        ret = ret + String.format("%3s"," |  " + score);
        
        
        return ret + "\r\n";
    }
    
    //public static void move(int n) {
    public void move(int n) {
        //if (move.equals(4)) {
            if (n == 4) {    
            gameBoard[1][2] = 0;
            gameBoard[1][3] = 5;
            gameBoard[1][4] = 5;
            gameBoard[1][5] = 5;
            score = 1;

        }
        
    }

    public int getPlayer() {
        int turn = 0;
        return turn;
    }

    public int getScore(int player) {
        if (player == 0) {

            return score2;
        } else {
            return score;
        }
    }
}
import java.util.*;

public class Mancala{

    private int [][] gameBoard;
    private int row = 2;
    private int col = 6;
    private int score1= 0;
    private int score0 = 0;
    private int playerTurn = 0;

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
        ret = ret + String.format("%4s",score1 + " |");
        for(int i = 0; i < 6; i++) {
            ret = ret + String.format("%3d", gameBoard[0][i]);
        }
        ret = ret + String.format("%4s", " |  ");
        if (playerTurn == 0) {
            ret = ret + "*";
        } else {
            ret = ret + "-";
        }

        ret = ret+"\n";

        if (playerTurn == 1) {
            ret = ret + String.format("%4s", "* |");
        } else {
            ret = ret + String.format("%4s", "- |");
        }

        for (int i = 0; i < 6; i++) {
            
            ret = ret + String.format("%3d", gameBoard[1][i]);
        }
        ret = ret + String.format("%4s"," |  " + score0 + "\n");
        

        return ret;
    }
    

    //you need to implement this. 
    //remember when we talked about checking each array to see if they are all 0
    //if either one is then the game is over
    private boolean gameOver() {
        //check arrays here and return true if either is all 0
        //else
        return false;
    }



    public boolean move(int n) {

        if (gameOver() == true) {
            return false;
        }
        int pit = 0; //the pit being selected. It is the nth pit from the current players goal
        int stones = 0; //number of stones removed from the pit selected

        if (playerTurn == 0) {
            playerTurn = 1; //next player turn
            //for player 0, the pit is bottom right on display. 
            //n is the pit to select so 6-n, where 6 is the number of pits, gives us the array element to start with
            pit = 6 - n;
            stones = gameBoard[1][pit]; // set the number of stones from the selected pit
            //if there aren't any stones to take, no move can be made
            if (stones == 0) {
                return false;
            }
            gameBoard[1][pit] = 0; //we took all the stones so there aren't any left

            //this is where it gets confusing. It's slightly different for player 0 then it is for player 1. 
            //for player 0 start with the pit next to the selected pit, loop until the last col, adding 1 to each pit.
            for (int s = pit + 1; s < col; s++) {
                if (stones > 0) {
                    gameBoard[1][s] = gameBoard[1][s] + 1;
                    stones = stones - 1;
                    //rule 4 test. If it's the last stone and it was put into an empty pit on players side
                    //then take it out and put it in the goal. Then take all the stones in the pit directly across
                    //and put them in the goal.
                    if(stones == 0) {
                        if(gameBoard[1][s] == 1) {
                            gameBoard[1][s] = 0;
                            score0 = score0 + 1;
                            score0 = score0 + gameBoard[0][s];
                            gameBoard[0][s] = 0; 
                        }
                    }
                    //end rule 4 test
                }
            }
            //if we have stones left over, add 1 to the goal
            if (stones > 0) {
                score0 = score0 + 1;
                stones = stones - 1;
                if(stones == 0) {
                    playerTurn = 0; //if your last stone is added to the goal, you get to go again.
                }
                //if we still have stones leftover, add them to the other side.
                if (stones > 0) {
                    //this is to keep track of the pits on the other side. We start at the 5th element of array (col 6)
                    int ctr = 5;
                    playerTurn = 1; //now you don't get to go again
                    while (stones > 0) {
                        //note the row is now 0 since we're adding to the other side
                        gameBoard[0][ctr] = gameBoard[0][ctr] + 1;
                        stones = stones - 1;
                        ctr = ctr - 1;
                    }
                }
            }
        } else {
            //for player 1 we do basically the same thing. The difference is the for loops have to count backwards
            //since we are going the other way.
            playerTurn = 0; //next player turn
            pit = n - 1;
            stones = gameBoard[0][pit];
            if (stones == 0) {
                return false;
            }
            gameBoard[0][pit] = 0;
            for (int s = pit - 1; s >= 0; s--) {
                gameBoard[0][s] = gameBoard[0][s] + 1;
                stones = stones - 1;
                //rule 4 test. See above.
                if(stones == 0) {
                    if(gameBoard[0][s] == 1) {
                        gameBoard[0][s] = 0;
                        score1 = score1 + 1;
                        score1 = score1 + gameBoard[1][s];
                        gameBoard[1][s] = 0; 
                    }
                }
                //end rule 4 test
            }
            if (stones > 0) {
                score1 = score1 + 1;
                stones = stones - 1;
                playerTurn = 1;
                if (stones > 0) {
                    //this time we start at the beginning of array, not the end
                    int ctr = 0;
                    playerTurn = 0;
                    while (stones > 0) {
                        gameBoard[1][ctr] = gameBoard[1][ctr] + 1;
                        stones = stones - 1;
                        ctr = ctr + 1;
                    }
                }
            }
        }
        //we made a move, return true
        return true;
    }


    public int getPlayer() {
        return playerTurn;
    }

    public int getScore(int player) {
        if (player == 0) {
            return score0;
        } else {
            return score1;
        }
    }
    public static void main(String[] args)
    {
        Mancala m = new Mancala();
        m.move(6);
        m.move(2);
        m.move(6);
        m.move(6);
        assert m.toString().equals(" 9 |  5  0  5  5  5  0 |  *\n - |  0  0  5  5  5  4 |  0\n") : m;
    }
}
import java.util.*;

public class Mancala{

    private int [][] gameBoard;
    private int row = 2;
    private int col = 6;
    private int score1= 0;
    private int score0 = 0;
    private int playerTurn = 0;
    private int stones = 0;

    public Mancala() {
        gameBoard = new int [row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameBoard[i][j] = 4;
            }
        }
    }
    
    
    public Mancala(int goal1, int[] pits, int goal0, int player) {
        //init the class variables to the values passed in on constructor.    
        score0 = goal0;
        score1 = goal1;
        playerTurn = player;

        gameBoard = new int [row][col];
        for (int i = 0; i < row; i++) {
            int offset = 0;
            
            //step through this in debugger to understand how it works
            if (i == 1) {
                offset = 6; //offset used to continue going over the pit array that is passed in on the constructor
            }

            for (int j = 0; j < col; j++) {
                gameBoard[i][j] = pits[j + offset];
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
        ret = ret + " |";
        ret = ret + String.format("%4s", score0 + "\n");
        

        return ret;
    }
    

    //you need to implement this. 
    //remember when we talked about checking each array to see if they are all 0
    //if either one is then the game is over
    public boolean gameOver() {
        //check arrays here and return true if either is all 0
        boolean p0Over = true;
        boolean p1Over = true;
        for (int j = 0; j < 6; j++) {
            if (gameBoard[0][j] > 0) {
                p0Over = false;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (gameBoard[1][j] > 0) {
                p1Over = false;
            }
        }
        return p0Over || p1Over;
    }

    private void calcFinalScore() {
        for (int j = 0; j < 6; j++) {
            score0 += gameBoard[0][j];
        }
        for (int j = 0; j < 6; j++) {
            score1 += gameBoard[1][j];
        }
    }

    private void side1Move(int pit) {
        
        //if (playerTurn == 0) {
            for (int s = pit + 1; s < col; s++) {
                if (stones > 0) {
                    gameBoard[1][s] = gameBoard[1][s] + 1;
                    stones = stones - 1;
                    //rule 4 test. If it's the last stone and it was put into an empty pit on players side
                    //then take it out and put it in the goal. Then take all the stones in the pit directly across
                    //and put them in the goal.
                    if (stones == 0) {
                        if (gameBoard[1][s] == 1 && row == 1) {
                            gameBoard[1][s] = 0;
                            score0 = score0 + 1;
                            score0 = score0 + gameBoard[0][s];
                            gameBoard[0][s] = 0;
                        }
                    }
                    //end rule 4 test
                }
            }
        

    }

    private void side0Move(int pit) {
        
        for (int s = pit - 1; s >= 0; s--) {
            if (stones > 0) {
                gameBoard[0][s] = gameBoard[0][s] + 1;
                stones = stones - 1;
                //rule 4 test. See above.
                if (stones == 0) {
                    if (gameBoard[0][s] == 1 && row == 0) {
                        gameBoard[0][s] = 0;
                        score1 = score1 + 1;
                        score1 = score1 + gameBoard[1][s];
                        gameBoard[1][s] = 0;
                    }
                }
            }
            //end rule 4 test
        }
    }

     private void move1(int pit, int row, int stones) {
    //     if (playerTurn == 0) {
    //         for (int s = pit + 1; s < col; s++) {
    //             if (stones > 0) {
    //                 gameBoard[row][s] = gameBoard[row][s] + 1;
    //                 stones = stones - 1;
    //                 //rule 4 test. If it's the last stone and it was put into an empty pit on players side
    //                 //then take it out and put it in the goal. Then take all the stones in the pit directly across
    //                 //and put them in the goal.
    //                 if (stones == 0) {
    //                     if (gameBoard[1][s] == 1 && row == 1) {
    //                         gameBoard[1][s] = 0;
    //                         score0 = score0 + 1;
    //                         score0 = score0 + gameBoard[0][s];
    //                         gameBoard[0][s] = 0;
    //                     }
    //                 }
    //                 //end rule 4 test
    //             }
    //         }
    //     } else {

    //         for (int s = pit - 1; s >= 0; s--) {
    //             if (stones > 0) {
    //                 gameBoard[row][s] = gameBoard[row][s] + 1;
    //                 stones = stones - 1;
    //                 //rule 4 test. See above.
    //                 if (stones == 0) {
    //                     if (gameBoard[0][s] == 1 && row == 0) {
    //                         gameBoard[0][s] = 0;
    //                         score1 = score1 + 1;
    //                         score1 = score1 + gameBoard[1][s];
    //                         gameBoard[1][s] = 0;
    //                     }
    //                 }
    //             }
    //             //end rule 4 test
    //         }
    //     }
     }
    public boolean move(int n) {

        if (gameOver() == true) {
            calcFinalScore();
            return false;
        }
        int pit = 0; //the pit being selected. It is the nth pit from the current players goal
        //int stones = 0; //number of stones removed from the pit selected

        if (playerTurn == 0) {
            
                //playerTurn = 1; //next player turn
                //for player 0, the pit is bottom right on display. 
                //n is the pit to select so 6-n, where 6 is the number of pits, gives us the array element to start with
            pit = 6 - n;
            stones = gameBoard[1][pit]; // set the number of stones from the selected pit
            
                //if there aren't any stones to take, no move can be made
            if (stones == 0) {
                playerTurn = 1;
                return false;
            }

            while (stones > 0) {
                gameBoard[1][pit] = 0; //we took all the stones so there aren't any left

                side1Move(pit);

                if (stones > 0) {
                    score0 = score0 + 1;
                    stones = stones - 1;
                    if (stones == 0) {
                        playerTurn = 0; //if your last stone is added to the goal, you get to go again.
                    }
                    //if we still have stones leftover, add them to the other side.
                    if (stones > 0) {

                        side0Move(6);
                        //this is to keep track of the pits on the other side. We start at the 5th element of array (col 6)

                        playerTurn = 1; //now you don't get to go again
                    }
                } else {
                    playerTurn = 1;
                }
            }
            
        } else {
            //for player 1 we do basically the same thing. The difference is the for loops have to count backwards
            //since we are going the other way.
            //playerTurn = 0; //next player turn
            pit = n-1;
            stones = gameBoard[0][pit];

            if (stones == 0) {
                playerTurn = 1;
                return false;
            }
            while (stones > 0) {
                gameBoard[0][pit] = 0;

                //move1(pit, 0, stones);
                side0Move(pit);

                if (stones > 0) {
                    score1 = score1 + 1;
                    stones = stones - 1;
                    if (stones == 0) {
                        playerTurn = 0; //if your last stone is added to the goal, you get to go again.
                    }
                    //if we still have stones leftover, add them to the other side.
                    if (stones > 0) {

                        side1Move(-1);
                        //this is to keep track of the pits on the other side. We start at the 5th element of array (col 6)

                        playerTurn = 0; //now you don't get to go again
                    }
                } else {
                    playerTurn = 1;
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
        int[] pits = {2,3,4,5,6,7,8,9,10,11,12,13};
        Mancala m = new Mancala(1,pits,14,0);
        assert m.toString().equals(" 1 |  2  3  4  5  6  7 |  *\n - |  8  9 10 11 12 13 | 14\n") : m;
    }
}
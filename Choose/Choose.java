import java.util.*;

public class Choose {
    int[] positionLocated = new int[2];
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int gameBoardSize = 0;
    int row = 0;
    int column = 0;
    String [][] gameBoard;
    boolean hTurn = false;


    public void read(Scanner s) {
        gameBoardSize = s.nextInt();
        if(s.next().equals("H"))
            hTurn = true;
        
        playerOneScore = s.nextInt();
        playerTwoScore = s.nextInt();
        gameBoard = new String[gameBoardSize][gameBoardSize];

        for(int i = 0; i < gameBoardSize; i++) {
            for(int j = 0; j < gameBoardSize; j++) {
                gameBoard[i][j] = s.next();
                if(gameBoard[i][j].equals( "@")) {
                     positionLocated[0] = i;
                     positionLocated[1] = j;
                }
                row = positionLocated[0];
                column = positionLocated[1];
            }
        }
    }

    public int getSize() {
        return gameBoardSize;
    }

    public char getPlayer() {
        if(hTurn)
            return "H".charAt(0);
        return "V".charAt(0);
        
    }

    //use the Ternary operator of if-then-else statement; colon = else
    public int getScore(char player) {
        int score = 0;
        if (String.valueOf(player).equals("H")) {
            score = playerOneScore;
        } else {
            score = playerTwoScore;
        }
        return score;
        //return String.valueOf(player).equals("H") ? playerOneScore : playerTwoScore;
    }

    public int getSelectionRow(){
        return row;
    }

    public int getSelectionCol(){
        return column;
    }

    //use the Ternary operator of if-then-else loop
    public int getValue(int c, int r) {
        int value = 0;
        if (gameBoard[c][r].equals("-") || gameBoard[c][r].equals("@")) {
            value = -1;
        } else {
            value = Integer.parseInt(gameBoard[c][r]);
        }
        return value;
        //return gameBoard[c][r].equals("-") || gameBoard[c][r].equals("@") ? -1 : Integer.parseInt(gameBoard[c][r]);
    }

    public void move(int n) {
        int[] location = new int[2];

        if(hTurn) {
            location[0] = positionLocated[0];
            location[1] = n;
        } else {
            location[0] = n;
            location[1] = positionLocated[1];
        }

        if(hTurn)
            playerOneScore = playerOneScore + Integer.parseInt(gameBoard[location[0]][location[1]]);
            
        else
            playerTwoScore = playerTwoScore + Integer.parseInt(gameBoard[location[0]][location[1]]);


        gameBoard[location[0]][location[1]] = "@"; 
        gameBoard[positionLocated[0]][positionLocated[1]] = "-";

        positionLocated[0] = location[0];
        positionLocated[1] = location[1];

        hTurn = !hTurn;
    }

    public String toString() {
        String ret = "";
        String turn = "V";

        if(hTurn)
            turn = "H";
        ret += (gameBoardSize + " " + turn + " " + getScore('H') + " " + getScore('V') + "\n");

        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                ret += (gameBoard[i][j] + " ");
            }
         ret += "\n";
        }
        return ret;

    }

}

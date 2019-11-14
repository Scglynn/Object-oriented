import java.util.Scanner;

public class MancalaPlayer {

    static final int playerOneTakes = 7;
    static final int playerTwoTakes = 0; 
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Mancala!");
        int[] gameBoard = placePitsingameBoard();
        boolean Player1Turn = true;
        while(!gameOver(gameBoard)) {
            Player1Turn = nextPlayer(gameBoard, Player1Turn);
        }
        finalScore(gameBoard, Player1Turn);
    }
    public static boolean nextPlayer(int[] gameBoard, boolean Player1Turn) {
        printBoard(gameBoard, Player1Turn);
        int move = getMove(gameBoard, Player1Turn);
        return makeMove(gameBoard, Player1Turn, move);
    }
    public static int getMove(int[] gameBoard, boolean Player1Turn) {
        int move = 0;
        boolean validMove = false;

        if(Player1Turn) {
            System.out.print("\nFirst player pick: ");
        } else {
            System.out.print("\nSecond player pick: ");
        }
        while (!validMove) {
            move = in.nextInt();
            
            if(Player1Turn) {
                move += 7;
            }
            
            if (!Player1Turn && move >= 1 && move <= 6  && gameBoard[move] > 0) {
                validMove = true;
            }
            else if (Player1Turn && move >= 8 && move <= 13 && gameBoard[move] > 0) {
                validMove = true;
            } else {
                System.out.print("Invalid move. Try again.\n");
                
                if(Player1Turn) {
                    System.out.print("First player pick: ");
                } else {
                    System.out.print("Second player pick: ");
                }
            }
        }
        return move;
    }
    public static void printBoard(int[] gameBoard, boolean Player1Turn) {
        char showStar = 0;
        char showDash = 0;
        System.out.println();
        
        if(Player1Turn) {
            showStar = '*';
            showDash = '-';
            
            System.out.printf("%2d",gameBoard[playerTwoTakes]);
            System.out.print(" |");
            
            for(int i = 1; i < 7; i++) {
                System.out.printf("%3d", gameBoard[i]);
            }

            System.out.print(" |  "+showStar);
            System.out.println();
            System.out.print(" "+showDash+" |");
            
            for(int i = 13; i > 7; i--) {
                System.out.printf("%3d", gameBoard[i]);
            }

            System.out.print(" |");
            System.out.printf("%3d", gameBoard[playerOneTakes]);
        } else {
            showStar = '*';
            showDash = '-';
            System.out.printf("%2d",gameBoard[playerTwoTakes]);
            System.out.print(" |");
            
            for(int i = 1; i < 7; i++) {
                System.out.printf("%3d", gameBoard[i]);
            }
            
            System.out.print(" |  "+showDash);
            System.out.println();
            System.out.print(" "+showStar+" |");
            
            for(int i = 13; i > 7; i--) {
                System.out.printf("%3d", gameBoard[i]);
            }
            
            System.out.print(" |");
            System.out.printf("%3d", gameBoard[playerOneTakes]);
        }
    }
    public static int[] placePitsingameBoard() {
        int[] gameBoard = new int[14];
        for(int i = 0; i < gameBoard.length; i++) {

            if(i != playerOneTakes && i != playerTwoTakes) {
                gameBoard[i] = 4;
            }
        }
        return gameBoard;
    }
    public static boolean makeMove(int[] gameBoard, boolean Player1Turn, int move) {
        int nstones = gameBoard[move];
        gameBoard[move] = 0;
        int currentPosition = move;
        while(nstones > 0) {
            currentPosition--;

            if(currentPosition < 0) {
                currentPosition += 14;
            }

            if(Player1Turn && currentPosition == playerTwoTakes) {
                continue;
            }
            else if (!Player1Turn && currentPosition == playerOneTakes) {
                continue;
            }
            gameBoard[currentPosition]++;
            nstones--;
        }
        if(((Player1Turn && 1 <= currentPosition && currentPosition <= 6) || (!Player1Turn && 8 <= currentPosition && currentPosition <= 13)) && (gameBoard[currentPosition] == 1) && (gameBoard[gameBoard.length - currentPosition] > 0)) {
            int target;
            if(Player1Turn) {
                target = playerOneTakes;
            } else {
                target = playerTwoTakes;
            }
            gameBoard[target] += gameBoard[currentPosition] + gameBoard[gameBoard.length - currentPosition];
            gameBoard[currentPosition] = 0;
            gameBoard[gameBoard.length - currentPosition] = 0;
        }
        if ((Player1Turn && currentPosition == playerOneTakes) || (!Player1Turn && currentPosition == playerTwoTakes)) {
            return Player1Turn;
        }
        return !Player1Turn;
    }
    public static boolean gameOver(int[] gameBoard) {
        int numStones = 0;
        for(int i = 1; i < 7; i++) {
            numStones += gameBoard[i];
        }
        if(numStones == 0) {
            return true;
        }
        for(int i = 8; i < 14; i++) {
            if(gameBoard[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void finalScore(int[] gameBoard, boolean Player1Turn) {
        printBoard(gameBoard, Player1Turn);
        int player1score = 0;
        for(int i = 0; i < 7; i++) {
            player1score += gameBoard[i];
        }
        int player2score = 0;
        for(int i = 7; i < 14; i++) {
            player2score += gameBoard[i];
        }
        if(player1score > player2score) {
            System.out.print("\nSecond player won, ");
            System.out.println(player2score + " to " + player1score+".");
        }
        else if(player1score < player2score) {
            System.out.print("\nFirst player won, ");
            System.out.println(player2score + " to " + player1score+".");
        } else {
            System.out.println("Tie game.");
        } 
    }
}
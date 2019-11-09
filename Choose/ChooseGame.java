import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ChooseGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = 0;
        int col = 0;        
        int p1=0;
        int p2=0;
        String turn;
        String nextTurn = "";

        row =Integer.parseInt(scan.next());
        col = row;
        turn = scan.next();
        p1 = scan.nextInt();
        p2 = scan.nextInt();

        String [][] values = new String [row][col];
        int r = 0;
        int c = 0;
        String next = "";

        for (int i=0; i < row; i++) {
            for (int j=0; j<col; j++) {
                next = scan.next();
                if (next.equals("@")) {
                    r = i;
                    c = j;
                }
                values[i][j] = next;
            }
        }
        int maximum = -10;
        int highR = 0;
        int highC = 0;
        
        if (turn.equals("V")) {
            highC = c;
            for (int i=0; i<row; i++) {
                if (i == r || values[i][c].equals("-")) {
                    continue;
                } else {
                    for (int j=0; j<col; j++) {
                        if (values[i][j].equals("-") || values[i][j].equals("@")) {
                            continue;
                        } else {
                            if (Integer.parseInt(values[i][c]) - Integer.parseInt(values[i][j])>maximum) {
                                maximum = Integer.parseInt(values[i][c]) - Integer.parseInt(values[i][j]);
                                highR = i;
                            }
                        }
                    }
                }
            }
            if (values[highR][highC].equals("-") || values[highR][highC].equals("@")) {
                p2 += 0;
                nextTurn = "V";
            } else {
                values[r][c] = "-";
                p2 += Integer.parseInt(values[highR][highC]);
                values[highR][highC] = "@";
                nextTurn = "H";
            }
        } else {
            highR = r;
            for (int i=0; i<col; i++) {
                if (i==c || values[r][i].equals("-")) {
                    continue;
                } else {
                    for (int j=0; j<row; j++) {
                        if (values[j][i].equals("-") || values[j][i].equals("@")) {
                            continue;
                        } else {
                            if (Integer.parseInt(values[r][i]) - Integer.parseInt(values[j][i])>maximum) {
                                maximum = Integer.parseInt(values[r][i]) - Integer.parseInt(values[j][i]);
                                highC = i;
                            }
                        }
                    }
                }
            }
            if (values[highR][highC].equals("-") || values[highR][highC].equals("@")) {
                p1 += 0;
                nextTurn = "H";
            } else {
                values[r][c] = "-";
                p1 += Integer.parseInt(values[highR][highC]);
                values[highR][highC] = "@";
                nextTurn = "V";
            }
        }
        System.out.printf("%d %s %d %d\n",row, nextTurn, p1, p2);
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                System.out.print(values[i][j]+" ");
            }
            System.out.println();
        }
    }
}
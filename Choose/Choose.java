
import java.util.*;

public class Choose {
    private int [][] value;
    private int size;    
    private String turn;
    private int H = 0;
    private int V = 0;
    private int row;
    private int col;

    public void read(Scanner s) {

        size =Integer.parseInt(s.next());
        turn = s.next();
        H = Integer.parseInt(s.next());
        V = Integer.parseInt(s.next());

    
        value = new int [size][size];

        while(s.hasNext()){
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    String nxt = s.next();
                    try {
                        if(nxt.equals("@")) {
                            value[r][c] = -2;
                        } 
                        if( nxt.equals("-")) {
                            value[r][c] = -1;
                        } else {
                            
                            value[r][c] = Integer.parseInt(nxt);
                        }
                    } catch (Exception e) {
                        
                    }
                    
                }
            }
        }

    } 

     public int getSize() {

            return size;
        }
        public char getPlayer() {

            return turn.charAt(0);
        }
        public int getScore(char player) {
            if (player == 'H') {

                return H;
                
            }else {

                return V;
            }
        }
        public int getSelectionRow(){
            return row;
        }
        public int getSelectionCol(){

            return col;
        }
        public int getValue(int r, int c) {
            
            
            return value[r][c];
        }

        
        private int getBestMove() {
            int max = 0; 
            if (turn == "H") {
                
                for(int c=0; c < size; c++) {
                    if(value[c][col] > max) {
                        max = value[c][col];
                        row = c;
                    }
                }

            } else {
                
                for(int c=0; c < size; c++) {
                    if(value[row][c] > max) {
                        max = value[row][c];
                        col = c;
                    }
                }
            }
            return max;          
        }

        public void move(int n) { 
            value[row][col] = -1; 
            int moveVal = getBestMove();
            if(moveVal > 0) {
                if (turn == "H") {
                    
                    H = H + moveVal;
                    
                    value[row][col] = -2;
                    turn = "V";

                } else {

                    V = V + moveVal;
                    value[row][col] = -2;
                    turn = "H";
                }          
            }
        }


        public String toString() {
            String ret = "";
            for (int x = 0; x < value.length; x++) {
                for (int y = 0; y < value.length; y++) {
                    if(value[x][y] == -1) {
                        ret = ret + String.format("%4s", "-");
                    } 
                    if(value[x][y] == -2) {
                        ret = ret + String.format("%4s", "@");
                    }
                    if(value[x][y] >= 0) {
                        ret = ret+(String.format("%4d",value[x][y]));
                    }
                }
                ret = ret+"\r\n";
            }
        return ret;
    }
    public static void main(String[] args)
    {
        Choose c = new Choose();
        Scanner s = new Scanner("2 H 5 6 1 2 @ 2");
        c.read(s);
        assert c.getSize()==2;
        assert c.getPlayer()=='H';
        assert c.getScore('H')==5;
        assert c.getScore('V')==6;
        assert c.getSelectionRow()==1 : c.getSelectionRow();
        assert c.getSelectionCol()==0;
        assert c.getValue(0,0)==1;
        assert c.getValue(0,1)==2;
    }

}
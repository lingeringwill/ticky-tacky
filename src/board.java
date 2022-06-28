import java.util.*;
enum Marker {
    CROSS,
    CIRCLE,
    BLANK,
}

public class board {
    private boolean game_over = false;
    private Marker board[][] = new Marker[3][3]; // the actual board logic, this is where I'll be editing the values
    private boolean p1turn = true; 
    
    public void init_board() { // sets the board to blank after each game
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = Marker.BLANK;
            }
        }
    }
    

    public void print_board() { // actaully prints out the contents of the board based on what the markers are labelled as
        char printb[][] = new char [3][3];
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i][j] == Marker.BLANK) {
                    printb[i][j] = '-';
                }
                if (board[i][j] == Marker.CIRCLE) {
                    printb[i][j] = 'O';
                }
                if(board[i][j] == Marker.CROSS) {
                    printb[i][j] = 'X';
                }
            }
        }

        for (int row = 0; row < 3; row++) {// cycles through the rows
            
            for(int col = 0; col < printb[row].length; col++) {//cycles through columns
                System.out.print(printb[row][col]);
            }
            System.out.println();
        }
        
        
      
    }

    public void play_game() {
          init_board();
          while(game_over == false) {
            print_board();
            while(p1turn) {
                int coor[] = p1_input();
                    if (board[coor[0]][coor[1]] == Marker.BLANK) {
                        board[coor[0]][coor[1]] = Marker.CIRCLE;
                        p1turn = false;
                    }
                    else{
                        System.out.println("This space is already in use");
                    }
                   
            }
            p1win();
            print_board();

           while(!p1turn) {
                int coor[] = p2_input();
                if (board[coor[0]][coor[1]] == Marker.BLANK) {
                    board[coor[0]][coor[1]] = Marker.CROSS;
                    p1turn = true;
                }
                else {
                    System.out.println("this space is already in use");
                }
            }
          }
    }
    private int[] p1_input() {
        System.out.println("player 1's turn");
        int input[] = new int[2];
        System.out.println("please input a row ");
        Scanner first = new Scanner(System.in);
        input[0] = first.nextInt();
    

        System.out.println("please input a column ");
        Scanner second = new Scanner(System.in);
        input[1] = second.nextInt();
        

       
        
        
        return input;
        
    }
    private int[] p2_input() {
        System.out.println("player 2's turn");
        int input[] = new int[2];
        System.out.println("please input a row");
        Scanner first = new Scanner(System.in);
        input[0] = first.nextInt();
      
        System.out.println("please input a column");
        Scanner second = new Scanner(System.in);
       input[1] = second.nextInt();
       

       
        return input;
        
    }

    private void p1win() {
        if (board[0][0] == Marker.CIRCLE && board[0][1] == Marker.CIRCLE && board[0][2] == Marker.CIRCLE) {
            System.out.println("you won my bruddah");
            game_over = true;
           
        }
    }

    private void p2win() {}
}

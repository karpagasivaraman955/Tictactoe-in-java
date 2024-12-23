import java.util.*;
public class Tictactoe {
    private static char[][] board;
    private static char currentplayer;
    private static int n;
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board n x n");
        n = sc.nextInt();
        board = new char[n][n];
        
        initializeBoard();

        currentplayer = 'X';
        int moves = 0;
        boolean gameWon = false;

        while(moves < n*n && !gameWon){
            printboard();
            System.out.println("Player " + currentplayer + ", enter your move (row and column):");
            int row = sc.nextInt()-1;
            int col = sc.nextInt()-1;
            if(isValidmove(row,col)){
                board[row][col] = currentplayer;
                moves++;
                if (checkWin(row,col)){
                    gameWon = true;
                    printboard();
                    System.out.println("Player " + currentplayer + " wins!");
                }
                else{
                    currentplayer = (currentplayer == 'X') ? 'O' : 'X';
                }
            
            }
            else{
                System.out.println("Invalid move. Try again.");
            }

        }

        if(!gameWon){
            printboard();
            System.out.println("It's a draw!");
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printboard(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidmove(int row,int col){
        return row >=0 && row < n && col >=0 && col < n && board[row][col] == '-';
    }

    public static boolean checkWin(int row ,int col){
        return checkRow(row) || checkCol(col) || checkDiagonal(row,col);
    }

    public static boolean checkRow(int row){
        for (int i = 0; i < n; i++) {
            if(board[row][i] != currentplayer){
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int col){
        for (int i = 0; i < n; i++) {
            if(board[i][col]!= currentplayer){
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonal(int row,int col){
        boolean diag1 =true ,diag2 = true;
        for (int i = 0;i<n;i++){
            if(board[i][i] != currentplayer){
                diag1 = false;
            }
            if (board[i][n-i-1] != currentplayer){
                diag2 = false;
            }
        }
        return diag1 || diag2;
    }
}
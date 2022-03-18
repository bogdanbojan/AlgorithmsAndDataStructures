package problems.backtracking.nqueens;

public class NQueensArray {
    private static void NQueens(int n)
    {
        int[][] board = new int[n][n];
        solveNQueens(board, 0);

    }

    // if you want only one solution you can make this bool -> stop when it finds it.
    // like here: https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
    private static void solveNQueens(int[][] board, int col) {
        if (col == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solveNQueens(board, col+1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board,int row, int col)
    {
        for (int i = 0; i < col; i++)
        {
            if (board[row][i] == 1) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = col; i < board.length && j >= 0 ; i++ , j--)
        {
            if (board[i][j] == 1) return false;
        }
        return true;
    }




    private static void printBoard(int[][] board)
    {
        for (int i=0; i < board.length; i++){
            for (int j=0; j < board.length; j++)
            {
                System.out.print("|");
                if (board[i][j] == 1){System.out.print("Q");}
                else                 {System.out.print("-");}
            }
            System.out.print("|");
            System.out.println();
        }
    }


    public static void main (String[] args)
    {
        NQueens(4);
    }


}

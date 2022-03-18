package problems.backtracking.sudokusolver;

import java.util.ArrayList;
import java.util.List;

// 9 ^ m  where m = nr. of empty slots.
// can be improved..this way of solving this does make sens to me though and it comes intuitively.


public class SudokuSolver {
    static int N = 9;

    public static boolean solveSudoku(int[][] board) {

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0)
                {
                    for (int nr = 1; nr <= N; nr++) {
                        if (isSafe(board, row, col, nr)){
                            board[row][col] = nr;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false; // it really mattered where I put this.
                }

            }
        }
        return true;

    }


    private static boolean isSafe(int[][] board, int x, int y, int val) {
        // check row
        for (int i = 0; i < N; i++) {
            if (board[x][i] == val) return false;
        }

        // check col
        for (int j = 0; j < N; j++) {
            if (board[j][y] == val) return false;
        }

        // check if nr not in 3x3 grid
        int r = x - x % 3;
        int c = y - y % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] board = {   {3, 0, 6, 5, 0, 8, 4, 0, 0},
                            {5, 2, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 7, 0, 0, 0, 0, 3, 1},
                            {0, 0, 3, 0, 1, 0, 0, 8, 0},
                            {9, 0, 0, 8, 6, 3, 0, 0, 5},
                            {0, 5, 0, 0, 9, 0, 6, 0, 0},
                            {1, 3, 0, 0, 0, 0, 2, 5, 0},
                            {0, 0, 0, 0, 0, 0, 0, 7, 4},
                            {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if  (solveSudoku(board)) System.out.println("It's solved");
        else System.out.println("Nope");
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(board[x][y] + " ");

            }
            System.out.println();
        }

    }
}


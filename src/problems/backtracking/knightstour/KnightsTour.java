package problems.backtracking.knightstour;

public class KnightsTour {
    /*
    // all the possible permutations in which the knight can move on the board
    x [2,2 ,-1, 1,-2, -2, -1, 1]
    y [1,-1, 2,-2, 1, -1, -2,-2]


    if ( step == 63 ) {
        return true;
    }

    for ( row; row < n; row++){
        if (isSafe(board, row, col)){
            board[row][column] = step++;
            if (backtrack(board, col+1, step)) return true;
            board[row][column] = 0;
    return false;



     */


    public static boolean knightsTour(int n) {
        int[][] board = new int[n][n];
        for (int x=0; x < board.length; x++){
            for (int y=0; y < board.length; y++)
            {
                board[x][y] = -1;
            }
        }

        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

        board[0][0] = 0;

        if (!solveKnightsTour(board, xMove, yMove,1,0,0)) return false;
        else printBoard(board);
        return true;
    }

    // it's easier to keep following with x,y instead of row/col in this case imo.
    private static boolean solveKnightsTour(int[][] board,
                                            int[]   xMove,
                                            int[]   yMove,
                                            int     move,
                                            int     x,
                                            int     y) {
        if (move == board.length * board.length) return true;
        // check if we can move the knight
        for (int k = 0; k < board.length; k++) {
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];
            if (isSafe(board, nextX, nextY)) {
                board[nextX][nextY] = move; // you can't have here move ++ ?!
                if  (solveKnightsTour(board, xMove, yMove, move+1, nextX, nextY)) return true; // you can't have here neither move ++
                else board[nextX][nextY] = -1; // can it run without the if?
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int x, int y) {
        if (x >= 0 && x < board.length &&
            y >= 0 && y < board.length &&
            board[x][y] == -1)
        {
            return true;
        }

        return false;
    }

    private static void printBoard(int[][] board) {
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board.length; y++)
            {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args)
    {
        knightsTour(8);

    }


}

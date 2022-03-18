package problems.backtracking.ratinamaze;

public class RatMaze {
    static int N;

    public static boolean ratInMaze(int[][] maze)
    {
        N = maze.length;
        int[][] mazeSolution = new int[N][N];
        if(!findPath(maze, mazeSolution, 0, 0)) return false;
        else printMaze(mazeSolution);
        return true;
    }

    public static boolean findPath(int[][] maze, int[][] mazeSolution, int x, int y)
    {
        if (x == N - 1 &&
            y == N - 1 &&
            maze[x][y] == 1) {
            mazeSolution[x][y] = 1;
            return true;
        }

            if (isSafe(maze, x, y))
            {
                if (mazeSolution[x][y] == 1) return false; // already part of the solution.

                mazeSolution[x][y] = 1;
                if (findPath(maze, mazeSolution, x + 1, y)) return true;
                if (findPath(maze, mazeSolution, x, y + 1)) return true;
                if (findPath(maze, mazeSolution, x - 1, y)) return true;
                if (findPath(maze, mazeSolution, x, y - 1)) return true;
//              if you want the rat to move in left and up you need the last 2 loops
                mazeSolution[x][y] = 0;
//                return false;
            }


        return false;

    }

    public static boolean isSafe(int[][] maze, int x, int y)
    {
        if ( x >= 0 && x < N &&
             y >= 0 && y < N &&
             maze[x][y] == 1)
        {
            return true;
        }

        return false;


    }



    public static void printMaze(int[][] maze)
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                System.out.print(maze[x][y] + " ");
            }
            System.out.println();
        }
    }


    public static void main (String[] args)
    {
        int[][] maze = {{1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}};

        ratInMaze(maze);
    }
}

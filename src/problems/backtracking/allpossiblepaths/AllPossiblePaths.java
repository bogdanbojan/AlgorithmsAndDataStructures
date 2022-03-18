package problems.backtracking.allpossiblepaths;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePaths {


    public static void possiblePaths(int[][] matrix, List<Integer> path,  int m, int n, int x, int y ) {
        if (x > m || y > n) return; // if it goes outside matrix

        path.add(matrix[x][y]); // it exists too fast so it needs to be before
        if (matrix[x][y] == matrix[m][n]) { System.out.println(path);}

        possiblePaths(matrix, path, m, n, x + 1, y);
        possiblePaths(matrix, path, m, n, x, y + 1);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args)
    {
        int m = 2;
        int n = 3;
        int matrix[][] = { { 1, 2, 3 },
                           { 4, 5, 6 } };
        List<Integer> path = new ArrayList<>();
        possiblePaths(matrix, path, m-1, n-1 , 0, 0); // -1 because 0 indexed.
    }

}

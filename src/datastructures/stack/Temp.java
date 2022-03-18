package datastructures.stack;
import java.util.*;

public class Temp {
        /*
        0  0  0
        0  0  0
        0  0  0
         */

        public static List<List<Integer>> nQueens(int n) {
                List<List<Integer>> result = new ArrayList<>();
                solveNQueens(n, 0, new ArrayList<Integer>(), result);
                printBoard(result);
                return result;
        }
        private static void printBoard(List<List<Integer>> boards)
        {


                for (List<Integer> list : boards){


                        for (int index = 0; index < list.size(); index++ )
                        {
                                int queen = list.get(index);
                                for (int j = 0; j < list.size(); j++ ) {
                                        System.out.print("|");
                                        if (j == queen) {
                                                System.out.print("Q" + "");
                                        }else {
                                                System.out.print("-" + "");
                                        }
                                }
                                System.out.print("|");
                                System.out.println();


                        }
                        System.out.println();
                        System.out.println();

                }

        }

        private static void solveNQueens(int n, int row, List<Integer> colPlacement,
                                         List<List<Integer>> result) {
                if (row == n) {
// All queens are legally placed.
                        result.add(new ArrayList<>(colPlacement));
                } else {
                        for (int col = 0;
                        col<n ;++col){
                                colPlacement.add(col);
                                if (isValid(colPlacement)) {
                                        solveNQueens(n, row + 1, colPlacement, result);
                                }
                                colPlacement.remove(colPlacement.size() - 1);
                        }
                }
        }

        // Test if a newly placed queen will conflict any earlier queens
// placed before.
        private static boolean isValid(List<Integer> colPlacement) {
                int rowID = colPlacement.size() - 1;
                for (int i = 0; i < rowID; ++i) {
                int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
                if (diff == 0 || diff == rowID - i){
                        return false;
                }
        }
        return true;
}



        public static void main(String[] args)
        {
                System.out.println(nQueens(4));
        }
}


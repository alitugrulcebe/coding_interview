package MySolutions.Array;

import java.util.Arrays;

public class RotateAntiClockWise {

  public static int[][] rotate90AntiClockWise(int[][] matrix) {
    int N = matrix.length;
    // Consider all squares one by one
    for (int x = 0; x < N / 2; x++) {
      int first = x;
      int last = N - 1 - x;
      // Consider elements in group of 4 in
      // current square
      for (int y = first; y < last; y++) {
        // store current cell in temp variable
        int temp = matrix[x][y];

        // move values from right to top
        matrix[x][y] = matrix[y][N - 1 - x];

        // move values from bottom to right
        matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y];

        // move values from left to bottom
        matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x];

        // assign temp to left
        matrix[N - 1 - y][x] = temp;
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1, 2, 3,4},
      {4, 5, 6,7},
      {7, 8, 9,10},
      {11, 12, 13,1}};
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    rotate90AntiClockWise(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }


  }
}

package MySolutions.Array;

public class RotateTry {
  public static int[][] rotate90AntiClockWise(int[][] matrix) {
    int loopCount = matrix.length/2;

    for(int i=0; i<loopCount; i++) {
      for(int j=i; j< matrix.length - i - 1; j++) {
        System.out.println(matrix.length-i-1-j);
        int val = matrix[i][j];
        matrix[i][j] = matrix[j][matrix.length-i-1];
        matrix[j][matrix.length-i-1] = matrix[matrix.length-i-1][matrix.length-j-1];
        matrix[matrix.length-i-1][matrix.length-j-1] = matrix[matrix.length-j-1][i];
        matrix[matrix.length-j-1][i] = val;
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1,2,3},
      {4,5,6},
      {7,8,9}};
    for(int i=0;i<matrix.length;i++) {
      for(int j=0;j<matrix[i].length;j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    rotate90AntiClockWise(matrix);
    for(int i=0;i<matrix.length;i++) {
      for(int j=0;j<matrix[i].length;j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }
}

package MySolutions.HackerRank;

public class TwoDArray {
    static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        int row = 0;
        for(int i=0;i<4;i++) {
            row = i;
            for(int j=0;j<4;j++) {
                int s = 0;

                for(int t=j;t<3+j;t++) {
                    s+= arr[row][t];
                }
                s += arr[row+1][j+1];
                row += 2;
                for(int t=j;t<3+j;t++) {
                    s+= arr[row][t];
                }

                if(s > sum)
                    sum = s;

                row = i;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0 ,1, 2, 4, 0}};
        System.out.println(hourglassSum(arr));
    }
}

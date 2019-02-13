package MySolutions.CodingNinja;

public class AreaSameValue2D {
    public static void findAreaHelper(int[][] arr, boolean[][] visited, int value, int x, int y) {

        if (x < 0 || x >= arr[0].length || y < 0 || y >= arr.length) {
            System.out.println("Base case x=" + x + " y=" + y);
            return;
        } else {
            System.out.println("x = " + x + " y= " + y + " Val = " + arr[y][x]);
        }

        if (visited[y][x] == true) {
            return;
        }
        visited[y][x] = true;


        if (arr[y][x] == value) {
            mArea++;
            //System.out.println("Value esit x = " + x + " y= " + y + " Val = " + arr[y][x]);
            findAreaHelper(arr, visited, value, x + 1, y);
            findAreaHelper(arr, visited, value, x, y + 1);
            findAreaHelper(arr, visited, value, x - 1, y);
            findAreaHelper(arr, visited, value, x, y - 1);
        }

    }

    static int mArea = 0;
    public static void findArea(int[][] arr, int x, int y) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        mArea = 0;
        findAreaHelper(arr, visited, arr[y][x], x, y);
    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{ {1,1,2},
                                    {1,3,3},
                                    {4,5,1}};
        findArea(arr,2,1);
        System.out.println("Count is " + mArea);
    }


}

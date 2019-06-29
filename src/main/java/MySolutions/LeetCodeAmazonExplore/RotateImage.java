package MySolutions.LeetCodeAmazonExplore;

public class RotateImage {
//    You are given an n x n 2D matrix representing an image.
//
//    Rotate the image by 90 degrees (clockwise).
//
//    Note:
//
//    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//    Example 1:
//
//    Given input matrix =
//            [
//            [1,2,3],
//            [4,5,6],
//            [7,8,9]
//            ],
//
//    rotate the input matrix in-place such that it becomes:
//            [
//            [7,4,1],
//            [8,5,2],
//            [9,6,3]
//            ]
//    Example 2:
//
//    Given input matrix =
//            [
//            [ 5, 1, 9,11],
//            [ 2, 4, 8,10],
//            [13, 3, 6, 7],
//            [15,14,12,16]
//            ],
//
//    rotate the input matrix in-place such that it becomes:
//            [
//            [15,13, 2, 5],
//            [14, 3, 4, 1],
//            [12, 6, 8, 9],
//            [16, 7,10,11]
//            ]
    static void rotate90Clockwise(int a[][],int N)
    {

        // Traverse each cycle
        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    // Function for print matrix
    static void printMatrix(int arr[][],int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }

// Driver code

    public static void main (String[] args)
    {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotate90Clockwise(arr,4);
        printMatrix(arr,4);
    }
}

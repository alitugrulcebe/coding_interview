package MySolutions.General;

public class GenelDeneme {

    public static long pow(int a, int b) {
        long[] M = new long[b + 1];
        M[0] = 1;
        M[1] = a;
        return powHelper(a, b, M);
    }

    public static long powHelper(int a, int b, long[] M) {
        if (M[b] == 0) {
            if (b % 2 == 0) {
                M[b] = powHelper(a, b / 2, M)
                        * powHelper(a, b / 2, M);
            } else {
                M[b] = powHelper(a, (b - 1) / 2, M)
                        * powHelper(a, (b - 1) / 2, M) * a;
            }
        }
        return M[b];
    }

    public static int peakIndexInMountainArray(int[] A) {
        int mid = A.length/2;
        int tracer = 0;
        int result = -1;
        int i=0;
        while(i < A.length) {
            if(A[tracer] < A[i]) {
                result = i;
                break;
            }
            i++;
        }
        int j = i + 1;
        System.out.println("j " + j + "i " + i);
        while(j < A.length) {
            System.out.println("j " + j + " i " + i);
            if(A[i] < A[j]) {
                System.out.println("H");
                result = 2;
                break;
            }
            j++;
        }

        return i;

    }

    public static void main(String[] args) {
        char c = 'a';
        int s = (int) (c - '0');

        int numericValue = (int)c;

        System.out.println(s);

        pow(7,12);

        int [] arr = new int[]{3,4,5,1};
        peakIndexInMountainArray(arr);


    }
}

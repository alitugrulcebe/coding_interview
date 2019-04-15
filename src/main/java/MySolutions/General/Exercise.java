package MySolutions.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Exercise {

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

    public static void fourWay(int values[]) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = values.length-1;

        //# These while loops place i,j,k and l to their corect positions
        while (values[i] == a) {
            i = i + 1;
            j = i;
            k = i;
        }
        while (values[j] == b) {
            j = j + 1;
            k = j;
        }

        while (values[k] == c) {
            k = k + 1;
        }
        while (values[l] == d) {
            l = l - 1;
        }
        //# Loops till k is less than l
        while (k<=l) {
            if (values[k] == a) {
                int t = values[i];
                values[i] = a;
                values[k] = t;
            } else if (values[k] == b) {
                int t = values[j];
                values[j] = b;
                values[k] = t;
            } else if (values[k] == d) {
                int t = values[l];
                values[l] = d;
                values[k] = t;
            }

            //# Again These while loops place i,j,k and l to their corect positions

            while (values[i] == a) {
                i = i + 1;
                j = i;
                k = i;
            }
            while (values[j] == b) {
                j = j + 1;
                k = j;
            }
            while (values[k] == c) {
                k = k + 1;
            }
            while (values[l] == d) {
                l = l - 1;
            }
        }

        for (int x=0;x<values.length;x++)
            System.out.print(values[x] + " ");
    }

    public static void main(String[] args) {

        char c = 'a';
        int s = (int) (c - '0');

        int numericValue = (int)c;

        System.out.println(s);

        pow(7,12);

        int [] arr = new int[]{3,4,5,1};
        peakIndexInMountainArray(arr);

//values = [a,b,c,d,a,d,a,b,c,d,d,d,d,d,a,a,a,a,c,c,a,a,b,b,a,b,b,a,a]
        int[] values = new int[]{1,2,3,4,1,4,1,2,3,4,4,4,4,4,1,1,1,1,1,3,3,1,1,2,2,1,2,2,1,1,};
        int[] values1 = new int[]{1,2,3,1,1,2,3,3,1,1,1,1,1,3,3,1,1,2,2,1,2,2,1,1,2};

        int[] aa = new int[]{1,2,3,4,5};
        int i = Arrays.binarySearch(aa, 3);
        System.out.println(i);
        fourWay(values1);
    }
}

package MySolutions.HackerRank;

import java.util.Arrays;

public class RotateArray {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] left = new int[d];
        for(int i=0;i<d;i++)
            left[i] = a[i];
        int c = a.length-d;
        for(int i=0;i<c;i++)
            a[i] = a[d++];

        int rest = c;
        for(int j=0;j<a.length-rest;j++)
            a[c++] = left[j];


        return a;
    }

    // Guzel cozum moduler aritmetik kullanmis
    static int[] Rotate(int[] a, int n) {

        int[] ret = new int[a.length];
        for(int i = 0; i < a.length; ++i) {
            ret[i] = a[(i + n) % a.length];
        }
        return ret;
    }

    public static void main(String[] args) {
        //Arrays.stream(Rotate(new int[]{1, 2, 3, 4, 5}, 4)).forEach(System.out::print);
    }
}

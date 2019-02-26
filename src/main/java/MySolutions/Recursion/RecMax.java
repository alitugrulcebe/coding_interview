package MySolutions.Recursion;

public class RecMax {

    public static int findMax(int[] A,int n) {
        if(n == 1) {
            return A[0];
        }
        return Integer.max(findMax(A,n-1),A[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{8,2,3,4,5,6},6));
    }
}

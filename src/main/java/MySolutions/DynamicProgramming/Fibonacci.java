package MySolutions.DynamicProgramming;

public class Fibonacci {
    //Topdown
    public static int fibTopDown(int n, int[] fib) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (fib[n] != 0) {
            return fib[n];
        } else {
            fib[n] = fibTopDown(n - 1, fib) + fibTopDown(n - 2, fib);
            return fib[n];
        }
    }

    //Bottom up
    public static int fibDP(int x) {
        int fib[] = new int[x + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < x + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[x];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] fib = new int[n + 1];
        System.out.println(fibTopDown(n, fib));
    }
}

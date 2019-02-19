package MySolutions.DynamicProgramming;

public class LCSBruteForce {

    static int calls = 0;

    static int LCS(String s1, String s2, int m, int n) {
        calls = calls + 1;
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return 0;
        }
        if (s1.charAt(m) == s2.charAt(n)) {
            return LCS(s1, s2, m - 1, n - 1) + 1;
        } else {
            return Math.max(LCS(s1, s2, m, n - 1), LCS(s1, s2, m - 1, n));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long startTime = System.currentTimeMillis();

        String s1 = "0gaattcagtta";
        String s2 = "0ggatcga";

        System.out.println(LCS(s1, s2, s1.length() - 1, s2.length() - 1));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " ms");
        System.err.println("Number of calls " + calls);

    }

}
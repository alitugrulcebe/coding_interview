package MySolutions.Recursion;

public class ClimbStarMemoization {


    public int climbStairsOrg(int n) {
        return climb_StairsORg(0, n);
    }

    // O(2^n)
    public int climb_StairsORg(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_StairsORg(i + 1, n) + climb_StairsORg(i + 2, n);
    }


    public static int climbStairsMemo(int n) {
        int memo[] = new int[n + 1];
        return climb_StairsMemo(0, n, memo);
    }

    // O(n)
    public static int climb_StairsMemo(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        System.out.println("Before I is :" + i + " N is :"  + n);
        int oneStep = climb_StairsMemo(i + 1, n, memo);
        System.out.println("After I is :" + i + " N is :"  + n);
        int twoStep = climb_StairsMemo(i + 2, n, memo);
        memo[i] = oneStep + twoStep;
        return memo[i];
    }

    //O(n)
    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairsMemo(3));
    }
}

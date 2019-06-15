package MySolutions.Tree;

public class AllUniqueBST {
    public static int numTrees(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        int num = numTrees(n, memo);
        System.out.println("MEMO ");
        for(int i=0;i<memo.length;i++)
            System.out.print(memo[i] + " ");
        return num;
    }

    private static int numTrees(int n, int[] memo) {
        if(memo[n] != 0) return memo[n];
        for(int i=1; i<=n; i++) {
            memo[n] += numTrees(i-1, memo) * numTrees(n-i, memo);
        }
        return memo[n];
    }

    public static int countTreesRec(int numKeys) {
        if (numKeys <=1) {
            return(1);
        }
        else {
            int sum = 0;
            int left, right, root;
            for (root=1; root<=numKeys; root++) {
                left = countTreesRec(root - 1);
                right = countTreesRec(numKeys - root);
                sum += left*right;
            }
            return(sum);
        }
    }


    public int countTrees(int n){
        int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for(int i=2; i <= n; i++){
            for(int j=0; j <i; j++){
                T[i] += T[j]*T[i-j-1];
            }
        }
        return T[n];
    }

    public static void main(String[] args) {
        numTrees(4);
        countTreesRec(5);
    }
}

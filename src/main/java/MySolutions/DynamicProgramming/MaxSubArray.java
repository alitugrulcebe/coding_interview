package MySolutions.DynamicProgramming;

public class MaxSubArray {
    public int maxSubArrayKadane(int[] arrA) {
        int max_end_here = arrA[0];
        int max_so_far = arrA[0];
        for(int i=1;i<arrA.length;i++){
            max_end_here = Math.max(arrA[i], max_end_here+arrA[i]);
            max_so_far = Math.max(max_so_far,max_end_here);
        }
        return max_so_far;
    }

    //dynamic programming
    //bottom up approach
    public int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution arrayyy
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
    }
}

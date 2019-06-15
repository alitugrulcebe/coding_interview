package MySolutions.DynamicProgramming;

public class MaxProfit {
    public static int maxProfit(int[] p) {
        if(p.length == 0) return 0;
        int buy = p[0], max = 0;
        for(int i=1; i < p.length; i++){
            max = Math.max(max, p[i]-buy);
            buy = Math.min(buy, p[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

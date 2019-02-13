package MySolutions.General;

public class MinJump {

    public static int minNumOfSteps(int[] arr) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }

        int[] opt = new int[arr.length];
        opt[0] = 0;
        for (int i=1; i<arr.length; i++) {
            int min=arr.length;
            for (int k=0; k<i; k++) {
                if (i-k <= arr[k]) {
                    min = Math.min(min,  opt[k]+1);
                }
            }
            opt[i] = min;
        }

        for (int i=1; i<arr.length; i++) {
            System.out.println("Opt [" + i + "] = " + opt[i]);
        }

        return opt[arr.length-1];
    }

    public static void main(String[] args) {
        minNumOfSteps(new int[]{2, 1, 1, 8, 1, 1, 1});
    }
}

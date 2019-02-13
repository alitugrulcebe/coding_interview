package MySolutions.General;

public class Recursive {

    // Returns true if the given string reads the same
// forwards as backwards.
// By default, true for empty or 1-letter strings.
    public static boolean isPalindrome(String s) {
        if (s.length() < 2) { // base case
            return true;
        } else { // recursive case
            if (s.toCharArray()[0] != s.toCharArray()[s.length() - 1]) {
                return false;
            }
            String middle = s.substring(1, s.length() - 2);
            return isPalindrome(middle);
        }
    }

    public static void printAllBinary(int digits, String output) {
        if(digits == 0) {
            System.out.print(output);
        } else {
            printAllBinary(digits-1, output + "0");
            printAllBinary(digits-1, output + "1");
        }
    }


    public static void printBinary(int n) {
        if (n < 2) {
// base case; same as base 10
            System.out.print(n);
        } else {
// recursive case; break number apart
            printBinary(n / 2);
            printBinary(n % 2);
        }
    }

    public static boolean splitArray(int[] nums) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return recArray(nums, index, sum1, sum2);
    }
    private static boolean recArray ( int[] nums, int index, int sum1, int sum2 ) {
        if ( index >= nums.length ) {
            System.out.println("###############BASE CASE##############");
            System.out.println("Index : " + index);
            System.out.println("Sum1 : " + sum1);
            System.out.println("Sum2 : " + sum2);
            return sum1 == sum2;
        }
        int value = nums[index];
        System.out.println("###############BEFORE##############");
        System.out.println("Index : " + index);
        System.out.println("Sum1 : " + sum1);
        System.out.println("Sum2 : " + sum2);

        boolean g1 = recArray(nums, index + 1, sum1 + value, sum2);
        System.out.println("###############BETWEEN##############");
        System.out.println("Index : " + index);
        System.out.println("Sum1 : " + sum1);
        System.out.println("Sum2 : " + sum2);
        boolean g2 = recArray(nums, index + 1, sum1, sum2 + value);
        System.out.println("###############AFTER##############");
        System.out.println("Index : " + index);
        System.out.println("Sum1 : " + sum1);
        System.out.println("Sum2 : " + sum2);

        System.out.println("G1 : " + g1 + " G2 : "+ g2);


        return g1 || g2;
    }


    public static void main(String[] args) {
        //sPalindrome("aaaraeaa");
        //printBinary(42);
        //printAllBinary(3,new MySolutions.String());

        int []arr = new int[]{1,2,3,5};
        System.out.println(splitArray(arr));

    }
}

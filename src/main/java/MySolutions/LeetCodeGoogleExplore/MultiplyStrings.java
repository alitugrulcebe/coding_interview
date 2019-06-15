package MySolutions.LeetCodeGoogleExplore;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        char[] n1Arr = num1.toCharArray();
        char[] n2Arr = num2.toCharArray();
        int v1 = 0;
        int index = 0;
        for(int i=n1Arr.length-1;i>=0;i--) {
            int val = (int)(n1Arr[i]-'0');
            System.out.println("Value is : " + val);
            v1 += val*(Math.pow(10,index));
            index++;
        }
        int v2 = 0;
        index = 0;
        for(int i=n2Arr.length-1;i>=0;i--) {
            int val = (int)(n2Arr[i]-'0');
            v2 += val*(Math.pow(10,index));
            index++;
        }
        return v1*v2 + "";

    }

    public static void main(String[] args) {
        System.out.println(multiply("2","3"));
    }
}

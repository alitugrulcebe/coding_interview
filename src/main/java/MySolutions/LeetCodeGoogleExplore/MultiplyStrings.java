package MySolutions.LeetCodeGoogleExplore;

import java.math.BigInteger;

public class MultiplyStrings {
//    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//    Example 1:
//
//    Input: num1 = "2", num2 = "3"
//    Output: "6"
//    Example 2:
//
//    Input: num1 = "123", num2 = "456"
//    Output: "56088"

    public String multiplySoln(String num1, String num2) {

        BigInteger number1 = convertToInt(num1);
        BigInteger number2 = convertToInt(num2);
        BigInteger total = number1.multiply(number2);
        return total.toString();

    }

    BigInteger convertToInt(String num){
        BigInteger total = new BigInteger("0");
        // eg 123 = 3 * 10^0 +
        //          2 * 10^1 +
        //          1 * 10^2

        for(int i = num.length()-1; i >=0; i--){
            int power = num.length() - i -1;

            BigInteger ten = new BigInteger("10");
            BigInteger multi = ten.pow(power);

            BigInteger digit = new BigInteger(num.charAt(i)+"");

            BigInteger product = multi.multiply(digit);
            total = total.add(product);
        }

        return total;
    }


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

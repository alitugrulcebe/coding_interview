package MySolutions.Leetcode;

import java.util.*;

public class Easy {
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;

        long result = 0;
        int tmp_x = Math.abs(x);

        while(tmp_x != 0){
            result = (result * 10) + tmp_x % 10;
            tmp_x /= 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return (int)(x < 0 ? -result : result);
    }

    public boolean isPalindrome(int x) {
        int result = 0;
        int y = x;
        while(y!=0) {
            result = (result*10) + y%10;
            y = y/10;
        }

        if(x == result) {
            if(x<0)
                return false;
            return true;
        } else {
            return false;
        }

    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result=0,negate = 0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == 'M')
                result += 1000;
            else if(chars[i] == 'D')
                result += 500;
            else if(chars[i] == 'C')
                result += 100;
            else if(chars[i] == 'L')
                result += 50;
            else if(chars[i] == 'X')
                result += 10;
            else if(chars[i] == 'V')
                result += 5;
            else if(chars[i] == 'I')
                result += 1;

            if (i + 1 < chars.length) {
                if (chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X'))
                    negate += 1;
                else if (chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C'))
                    negate += 10;
                else if (chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M'))
                    negate += 100;
            }
        }
        return result - 2* negate;
    }


    /* Longest Common Prefix START */
    public String longestCommonPrefixUtil(String str1,String str2){
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        // Compare str1 and str2
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }

        return (result);
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i=1;i<strs.length;i++) {
            prefix = longestCommonPrefixUtil(prefix,strs[i]);
        }
        return prefix;
    }
    /* Longest Common Prefix END */


    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        if(s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(stack.isEmpty() || !isValidUtil(stack.pop(),c))
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;
        else
            return true;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }



    private boolean isValidUtil(Character pop, char c) {
        if((pop == '{' && c == '}') || (pop == '(' && c == ')') || (pop == '[' && c == ']'))
            return true;
        else
            return false;
    }

    public int strStrMore(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0;i < haystack.length() - needle.length();i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                String x =haystack.substring(i,i+needle.length());
                if (x.equals(needle))
                    return i;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;

        if(haystack.length() < needle.length())
            return 0;

        char[] hchars = haystack.toCharArray();
        char[] nchars = needle.toCharArray();
        int j=0;
        for(int i=0;i<hchars.length;i++) {
            boolean found = true;
            if(hchars[i] == nchars[j]) {
                int x = i;
                for(int t=1;t<nchars.length;t++) {
                    if(x+1 != hchars.length)
                        x++;
                    if (hchars[x] != nchars[t]) {
                        found = false;
                        break;
                    }

                }
                if(found) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == target)
                return i;
        }

        for(int i=0;i<nums.length;i++) {
            if(target < nums[i]) {
                return i;
            }
        }
        return nums.length-1;
    }



    public int maxSubArray(int[] nums) {
        int max_sum = 0;
        int max_global = Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++) {
            max_sum = max_sum + nums[i];

            if(max_global < max_sum)
                max_global = max_sum;
        }
        return max_global;
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();

        // Creates a substring from the last space to the end of the word and finds length
        if (s.lastIndexOf(" ") != -1)
            return (s.substring(s.lastIndexOf(" ")+1)).length();

        return s.length();

    }

    // TODO
    public static int[] plusOne(int[] digits) {
        if((digits[digits.length-1] + 1) % 10 == 0) {
            int zeroCount = (digits[digits.length-1] + 1)/10;
            int [] arr = new int[digits.length+zeroCount];
            System.arraycopy(digits,0,arr,0,digits.length);
            for(int i=arr.length-1-zeroCount;i>=0;i--) {
                if((arr[i] + 1) % 10 == 0) {
                    if( i == 0) {
                        arr[i] = 1;
                        break;
                    }
                    else
                        arr[i] = 0;
                }
                else {
                    arr[arr.length-1-zeroCount] = arr[arr.length-1-zeroCount] + 1;
                }
            }
            for(int i=digits.length;i<arr.length;i++) {
                arr[i] = 0;
            }
            return arr;

        } else {
            digits[digits.length-1] = digits[digits.length-1]+1;
            return digits;
        }
    }

    public static ArrayList<String> stringPerm(String str) {
        ArrayList<String> perms = new ArrayList<>();
        if(str.length() == 0) {
            perms.add("");
            return perms;
        } else {
            char prefix = str.charAt(0);
            String substring = str.substring(1);
            ArrayList<String> substrings = stringPerm(substring);
            for(String s:substrings) {
                for (int i=0; i<=s.length();i++) {
                    String beginning = s.substring(0,i);
                    String middle = Character.toString(prefix);
                    String end = s.substring(i);
                    perms.add(beginning + middle + end);
                }
            }

        }
        printResult(perms);
        return perms;
    }

    private static void printResult(ArrayList<String> perms) {
        for(String s:perms) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Easy e = new Easy();
        long a = Long.parseLong("9646324351");
        //System.out.println(e.reverse((int)a));

        //System.out.println(e.isPalindrome(121));

        //System.out.println(e.romanToInt("MCMXCIV"));

        String [] strs = new String[]{"flower","flight","flew"};
        //System.out.println(e.longestCommonPrefix(strs));

        //System.out.println(e.isValid("["));
        //e.removeDuplicates(new int[]{1,2,3,3,3,4,4,4,5,5,6,6,7,7,7,7,7,8});

        //DSystem.out.println(e.strStr("aaa","aaaa"));

        //e.countAndSay(6);

        e.lengthOfLastWord("        ");

        int [] x = new int[]{9,9};
        //plusOne(x);
        stringPerm("abc");




    }


}

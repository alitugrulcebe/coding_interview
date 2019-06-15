package MySolutions.LeetCodeMicrosoft;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        if(s.length() <= 1) return false;
        HashMap<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        Stack<String> stack = new Stack<>();
        char[] chArr = s.toCharArray();
        for(int i=0;i<chArr.length;i++) {
            if(chArr[i] == '(' ||
                    chArr[i] == '[' ||
                    chArr[i] == '{')
                stack.push(chArr[i] +"");

            if(chArr[i] == ')' ||
                    chArr[i] == ']' ||
                    chArr[i] == '}') {
                if (!stack.isEmpty()) {
                    String bracket = stack.pop();
                    if (!map.get(bracket).equals(chArr[i] + ""))
                        return false;
                } else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}

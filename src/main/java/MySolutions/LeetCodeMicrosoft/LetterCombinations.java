package MySolutions.LeetCodeMicrosoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Integer,String> letters= new HashMap<>();
        letters.put(2,"abc");
        letters.put(3,"def");
        letters.put(4,"ghi");
        letters.put(5,"jkl");
        letters.put(6,"mno");
        letters.put(7,"pqrs");
        letters.put(8,"tuv");
        letters.put(9,"wxyz");
        List<String> current = new ArrayList<>();
        helper(digits,0,"",letters,result);
        return result;
    }

    public static void helper(String digit,int index,String current,HashMap<Integer,String> letters,List<String> result) {
        if(index == digit.length()) {
            result.add(current);
            return;
        }

        for(char ch:letters.get(digit.toCharArray()[index] - '0').toCharArray()) {
            helper(digit,index+1,current+ch,letters,result);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}

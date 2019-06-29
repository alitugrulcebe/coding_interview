package MySolutions.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteAllPossibleStrings {

    public static List<List<String>> subsets(String s) {
        List<List<String>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), s, 0);
        return list;
    }

    private static void subsetsHelper(List<List<String>> list , List<String> resultList, String nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.length(); i++){
            // add element
            resultList.add(nums.charAt(i)+"");
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);

        } else {
            for (int noMore = 0; noMore <= 1; noMore++) {
                if (noMore == 0) {
                    for (int i = 0; i < word.length(); i++) {
                        permutation(perm + word.charAt(i), word.substring(i + 1, word.length()));
                    }
                } else {
                    permutation(perm, "");
                }
            }
        }
    }


    // All possibilities
    public static void permute(String sofar,String rest) {
        if(rest.isEmpty()) {
            System.out.println(sofar);
        } else {
            permute(sofar + rest.substring(0,1),rest.substring(1));
            permute(sofar,rest.substring(1));
        }
    }


    public static void main(String[] args) {
        //permute("","ABC");
        //permutation("","ABC");
        System.out.println(subsets("ABC"));
    }
}

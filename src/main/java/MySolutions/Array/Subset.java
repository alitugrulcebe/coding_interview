package MySolutions.Array;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        helper(arr,0,new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] arr,int index, List<Integer> current,List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i=index;i<arr.length;i++) {
            current.add(arr[i]);
            helper(arr,i+1,current,result);
            current.remove(current.size()-1);
        }
    }

    public static List<List<Integer>> generatePowerset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        helper2(arr,0,new ArrayList<>(), result);
        return result;
    }

    private static void helper2(int[] arr,int index, List<Integer> selectedSoFar,List<List<Integer>> powerSet) {
        if(index == arr.length) {
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }

        selectedSoFar.add(arr[index]);
        helper2(arr,index+1,selectedSoFar,powerSet);
        selectedSoFar.remove(selectedSoFar.size()-1);
        helper2(arr,index+1,selectedSoFar,powerSet);
    }

    public static void main(String[] args) {
        System.out.println(generateSubsets(new int[]{1,2,3}));
        System.out.println(generatePowerset(new int[]{1,2,3}));
    }
}

package MySolutions.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HighFiveLeetCode {

    public static int[][] highFive(int[][] items) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            List<Integer> list = null;
            if(!map.containsKey(id)) {
                list = new ArrayList<>();
                list.add(score);
            } else {
                list = map.get(id);
                list.add(score);
            }
            map.put(id, list);
            count.put(id, count.getOrDefault(id, 0) + 1);
        }
        int[][] result = new int[count.size()][2];
        int index = 0;
        for (Integer id : count.keySet()) {
            int[] r = new int[2];
            r[0] = id;
            List<Integer> list = map.get(id);
            Collections.sort(list);
            int size = 0;
            int sum = 0;
            int counter = 0;
            for(int i=list.size()-1;i>=0;i--) {
                if(size < 5) {
                    sum += list.get(i);
                    counter++;
                }
                size++;
            }
            r[1] =  sum / counter;
            result[index++] = r;
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] five = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        highFive(five);
    }
}
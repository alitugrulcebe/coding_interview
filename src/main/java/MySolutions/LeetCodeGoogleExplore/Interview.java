package MySolutions.LeetCodeGoogleExplore;

import javafx.util.Pair;

import java.util.*;

public class Interview {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[][] m = {{ 0,0,0,0,1,0,0},
                { 0,0,0,1,0,0,0 },
                { 0,0,0,0,0,0,1 },
                { 0,0,1,0,0,0,0 },
                { 0,1,0,0,1,0,0 }};
        HashMap<Integer, List<Pair<Integer,Integer>>> map = new HashMap<>();
        for(int i=0;i<m.length;i++) {
            List<Pair<Integer,Integer>> list = new ArrayList<>();
            for(int j=0;j<m[i].length;j++) {
                if(m[i][j] != 0) {
                    list.add(new Pair<>(m[i][j],j));
                }
            }
            map.putIfAbsent(i,list);
        }
        multiply(a,m,map);
    }

    private static void multiply(int[] a, int[][] m, HashMap<Integer, List<Pair<Integer, Integer>>> map) {
        List<Integer> l = new ArrayList<>();
        for(int j=0;j<m.length;j++) {
            int sum = 0;
            List<Pair<Integer, Integer>> pairList = map.get(j);
            for(Pair pair:pairList) {
                int val = (int)pair.getKey();
                int pos = (int)pair.getValue();
                sum += val * a[pos];
            }
//            for(int i=0;i<a.length;i++) {
//                sum += a[i] * m[j][i];
//            }
            l.add(sum);
        }
        System.out.println(l);
    }
}

package MySolutions.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class _ArrayTry {

    public static int[] sortedSquares(int[] A) {
        return Arrays.stream(A).boxed().map(x->x*x).sorted().mapToInt(j -> j).toArray();
    }

    static int findMaxSubSet(List<Integer> list, int maxL) {
        int max= Integer.MIN_VALUE;
        int index = -1;
        boolean backOrNot = false;
        for(int i=0;i<list.size();i++) {
            int sum = 0;
            int l = i+maxL;
            if(l >= list.size())
                l = list.size();
            for(int j=i;j<l;j++) {
                sum += list.get(j);
            }
            int tmp = max;
            max = Integer.max(max,sum);
            if(tmp != max)
                index = i;
        }

        for(int i=list.size()-1;i>0;i--) {
            int sum = 0;
            int l = i-maxL;
            if(l < 0)
                l = 0;
            for(int j=i;j>l;j--) {
                sum += list.get(j);
            }
            int tmp = max;
            max = Integer.max(max,sum);
            if(tmp != max) {
                index = i;
                backOrNot = true;
            }
        }

        if(backOrNot) {
            int l = index-maxL;
            if(l < 0)
                l =  0;
            for(int i=l;i>index;i--) {
                list.remove(i);
            }
        } else {
            int l = index+maxL;
            if(l >= list.size())
                l =  list.size()-1;
            System.out.println("Index " + index);
            System.out.println("L is " + l);
            for(int i=l;i>index-1;i--) {
                list.remove(i);
            }
        }
        return max;
    }
    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int maxL = -1;
        int minL = -1;
        if(L > M) {
            maxL = L;
            minL = M;
        } else {
            maxL = M;
            minL = L;
        }
        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        int s1 = findMaxSubSet(arr,L);
        System.out.println("Size " + arr.size());
        for(int i=0;i<arr.size();i++)
            System.out.print(arr.get(i) + " ");
        int s2 = findMaxSubSet(arr,M);
        System.out.println("S1 " + s1 + " S2 " + s2);
        return s1 + s2;
    }

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-1, -4, 3, 5, 6});

        HashMap<Integer,Integer> map = new HashMap<>();

        int [] arr = {1,0,3};//{2,1,5,6,0,9,5,0,3,8};


        maxSumTwoNoOverlap(arr,1,2);
    }
}

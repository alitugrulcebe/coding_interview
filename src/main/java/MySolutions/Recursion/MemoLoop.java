package MySolutions.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoLoop {
    private static Map<Integer,Integer> mem = new HashMap<>();
    public static int recLoop(int num)
    {
        if(num == 1)
            return 1;
        int sum = num;
        if(!mem.containsKey(num)) {
            for (int i = 1; i < num; i++)
                sum = sum + recLoop(i);
            mem.put(num,sum);
            return sum;
        } else {
            return mem.get(num);
        }
    }

    public static void main(String[] args) {
        int sum1 = recLoop(5);
        System.out.println(sum1);
    }
}

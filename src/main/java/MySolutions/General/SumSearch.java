package MySolutions.General;

import java.util.HashSet;

public class SumSearch {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};

        int sum = 10;

        HashSet<Integer> s = new HashSet<Integer>();
        for (int i=0; i<array.length; ++i)
        {
            int temp = sum-array[i];

            // checking for condition
            if (temp>=0 && s.contains(temp))
            {
                System.out.println("Pair with given sum " +
                        sum + " is (" + array[i] +
                        ", "+temp+")");
            }
            s.add(array[i]);
        }
    }
}

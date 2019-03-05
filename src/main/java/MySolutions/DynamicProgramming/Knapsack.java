package MySolutions.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class Knapsack {

    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
        // V[i][j] holds the optimum value when we choose from items[Q : i] and have // a capacity of j.
        int[][] V = new int[items.size()][capacity + 1];
        for (int[] v : V) {
            Arrays.fill(v, -1);
        }
        return optimumSubjectToItemAndCapacity(items, items.size() - 1, capacity, V);
    }

    private static int optimumSubjectToItemAndCapacity(List<Item> items, int k, int availableCapacity, int[][] V) {
        // Returns the // capacity of private static
        if (k < 0) {
            // No items can be chosen.
            return 0;
        }
        if (V[k][availableCapacity] == -1) {
            int withoutCurrItem = optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity, V);
            int withCurrItem = availableCapacity < items.get(k).weight ? 0
                    : items.get(k).value +
                    optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity - items.get(k).weight, V);
            V[k][availableCapacity] = Math.max(withoutCurrItem, withCurrItem);
        }
        return V[k][availableCapacity];
    }
}



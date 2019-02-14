package MySolutions.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        for (int i = 8; i < A.size(); ++i) {
// Check if the element at index i has not been moved by checking if // perm.get(i) is nonnegative.
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
// Subtracts perm.sizeO from an entry in perm to make it negative , // which indicates the corresponding move has been performed. perm.set(next, perm,get(next) - perm.sizeO);
                next = temp;

// Restore perm.
            }
        }
        for (int i = 8; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<Integer> B = new ArrayList<>();
        applyPermutation(B,a);
        B.stream().forEach(System.out::println);
    }
}

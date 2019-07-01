package MySolutions.EPI.array;

import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static List<Integer> nextPermutation(List<Integer> perm) {
        int k = perm.size() - 2;
        while(k>0 && perm.get(k) >= perm.get(k+1))
            k--;

        if(k == -1) {
            return Collections.emptyList(); // perm is the last permutation
        }

        for (int i = perm.size() -1 ; i > k ; i--) {
            if(perm.get(i) > perm.get(k)) {
                Collections.swap(perm,k,i);
                break;
            }
        }
        Collections.reverse(perm.subList(k+1,perm.size()));
        return perm;
    }
}

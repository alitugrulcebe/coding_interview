package MySolutions.Tree;

import java.util.ArrayList;

public class BSTMinDiffer {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        minDiffInBSTHelper(root,arr);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++) {
            int diff = arr.get(i+1) - arr.get(i);
            if(diff < min )
                min = diff;
        }
        return min;
    }

    public void minDiffInBSTHelper(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        minDiffInBSTHelper(root.left,arr);
        arr.add(root.val);
        minDiffInBSTHelper(root.right,arr);
    }
}

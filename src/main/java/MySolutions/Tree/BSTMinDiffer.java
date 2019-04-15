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

    private static int diffGlobal = Integer.MAX_VALUE;
    public static int minDiffInBST1(TreeNode root) {
        if(root == null) return diffGlobal;

        if(root.left != null && root.right != null) {
            int leftDiff = Math.abs(root.val-root.left.val);
            int rightDiff = Math.abs(root.val-root.right.val);
            int minDiff= Integer.min(leftDiff,rightDiff);
            diffGlobal = Integer.min(minDiff,diffGlobal);
        }

        minDiffInBST1(root.left);
        minDiffInBST1(root.right);

        return diffGlobal;
    }

    Integer res;
    Integer prev;

    public int minDiffInBSTOtherSolution(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev !=  null){
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println(minDiffInBST1(BSTTreeQuestions.createBSTTree().getRoot()));
    }
}

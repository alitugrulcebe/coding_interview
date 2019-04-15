package MySolutions.Tree;

import java.util.ArrayList;

public class BSTLeftSubtree {
    // SUM of left leaves
    public static int sumLeft(TreeNode root) {
        if(root == null ) {
            return 0;
        } else if(root.left != null && root.left.left == null && root.left.right ==null) {
            return root.left.val + sumLeft(root.right);
        } else {
            return sumLeft(root.left) + sumLeft(root.right);
        }
    }

    private static ArrayList<Integer> arrays = new ArrayList<>();
    public static int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesHelper(root);
        int sum = 0;
        for(int i=0;i<arrays.size();i++)
            sum += arrays.get(i);
        return sum;
    }

    public static void sumOfLeftLeavesHelper(TreeNode root) {
        if(root == null) return;

        if(root.left != null && root.left.left == null && root.left.right == null)
            arrays.add(root.left.val);
        sumOfLeftLeavesHelper(root.left);
        sumOfLeftLeavesHelper(root.right);
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        System.out.println(sumOfLeftLeaves(bstree.getRoot()));
    }
}

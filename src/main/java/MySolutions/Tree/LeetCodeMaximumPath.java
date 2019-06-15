package MySolutions.Tree;

public class LeetCodeMaximumPath {

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private static int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return Math.max(root.val + left, root.val + right);
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(-10);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        maxPathSum(r);
        System.out.println(max);
    }
}

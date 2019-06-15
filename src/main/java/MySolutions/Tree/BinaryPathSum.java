package MySolutions.Tree;

public class BinaryPathSum {

    public static int findBinaryPathSum(TreeNode root) {
        return helper(root,0);
    }

    private static int helper(TreeNode root, int sum) {
        if(root == null) return 0;

        sum = sum * 2 + root.val;
        if(root.left == null && root.right == null)
            return sum;
        return  helper(root.left,sum) +
                helper(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        System.out.println(findBinaryPathSum(root));
    }
}

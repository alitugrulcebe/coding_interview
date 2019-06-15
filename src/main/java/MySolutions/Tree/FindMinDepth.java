package MySolutions.Tree;

public class FindMinDepth {

    public int getMinDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null)
            return 1;

        int left = root.left != null?getMinDepth(root.left):Integer.MAX_VALUE;
        int right = root.right!=null?getMinDepth(root.right):Integer.MAX_VALUE;

        return 1 + Integer.min(left,right);

    }
}

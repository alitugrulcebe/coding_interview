package MySolutions.Tree;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        if(root.val == val)
            return root;

        TreeNode newLeftRoot = searchBST(root.left,val);
        TreeNode newRightRoot = searchBST(root.right,val);
        return newLeftRoot != null ? newLeftRoot:newRightRoot;
    }
}

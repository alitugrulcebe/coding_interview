package MySolutions.Tree;

public class ReverseAlternateTree {

    void preorder(TreeNode root1,  TreeNode root2, int lvl)
    {
        // Base cases
        if (root1 == null || root2==null)
            return;

        // Swap subtrees if level is even
        if (lvl%2 == 0)
            swap(root1.val, root2.val);

        // Recur for left and right subtrees (Note : left of root1
        // is passed and right of root2 in first call and opposite
        // in second call.
        preorder(root1.left, root2.right, lvl+1);
        preorder(root1.right, root2.left, lvl+1);
    }

    private void swap(int val, int val1) {
        int t = val;
        val = val1;
        val1 = t;
    }

    // This function calls preorder() for left and right children
// of root
    void reverseAlternate(TreeNode root)
    {
        preorder(root.left, root.right, 0);
    }
}

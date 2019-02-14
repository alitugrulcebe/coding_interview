package MySolutions.Tree;

public class LowestCommonAnchestor {
    TreeNode lca(TreeNode treeNode, int n1, int n2)
    {
        if (treeNode == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (treeNode.val > n1 && treeNode.val > n2)
            return lca(treeNode.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (treeNode.val < n1 && treeNode.val < n2)
            return lca(treeNode.right, n1, n2);

        return treeNode;
    }
}

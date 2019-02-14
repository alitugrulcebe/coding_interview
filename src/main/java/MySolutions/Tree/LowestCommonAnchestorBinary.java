package MySolutions.Tree;

public class LowestCommonAnchestorBinary {
    public static TreeNode lca(TreeNode treeNode, int n1, int n2)
    {
        if (treeNode == null)
            return null;

        if(treeNode.val == n1 || treeNode.val == n2)
                return treeNode;

        TreeNode left = lca(treeNode.left,n1,n2);
        TreeNode right = lca(treeNode.right,n1,n2);

        if(left != null && right != null)
            return treeNode;

        if(left == null && right == null)
            return null;
        
        return left != null ? left: right;
    }

    public static void main(String[] args) {
        BSTTreeQuestions binaryTree = BSTTreeQuestions.createBinaryTree();
        TreeNode treeNode = lca(binaryTree.getRoot(),5,13);
        System.out.println(treeNode.val);
    }
}

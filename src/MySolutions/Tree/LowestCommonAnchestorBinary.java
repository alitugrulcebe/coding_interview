package MySolutions.Tree;

public class LowestCommonAnchestorBinary {
    public static BSTTreeQuestions.Node lca(BSTTreeQuestions.Node node, int n1, int n2)
    {
        if (node == null)
            return null;

        if(node.val == n1 || node.val == n2)
                return node;

        BSTTreeQuestions.Node left = lca(node.left,n1,n2);
        BSTTreeQuestions.Node right = lca(node.right,n1,n2);

        if(left != null && right != null)
            return node;

        if(left == null && right == null)
            return null;
        
        return left != null ? left: right;
    }

    public static void main(String[] args) {
        BSTTreeQuestions binaryTree = BSTTreeQuestions.createBinaryTree();
        BSTTreeQuestions.Node node = lca(binaryTree.getRoot(),5,13);
        System.out.println(node.val);
    }
}

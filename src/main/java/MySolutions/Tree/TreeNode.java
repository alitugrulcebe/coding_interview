package MySolutions.Tree;

public class TreeNode implements PrintableTreeNode.PrintableNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode() {}
    TreeNode(int val) { this.val = val;}

    @Override
    public PrintableTreeNode.PrintableNode getLeft() {
        return left;
    }

    @Override
    public PrintableTreeNode.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return val + "";
    }
}

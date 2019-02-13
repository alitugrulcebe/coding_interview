package MySolutions.Tree;

public class IsBST {
    public static boolean isBST(BSTTreeQuestions.Node root) {
        if(root == null)
            return true;

        if(root.left != null) {
            if(root.left.val > root.val)
                return false;
        }
        if(root.right != null) {
            if(root.val > root.right.val)
                return false;
        }

        return isBST(root.left) && isBST(root.right);
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        System.out.println(isBST(bstree.getRoot()));
    }
}

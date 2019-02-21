package MySolutions.Tree;

public class TrimBST {
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstTreeQuestions = BSTTreeQuestions.createTrimTree();
        TreeNode treeNode = trimBST(bstTreeQuestions.getRoot(), 1, 5);
    }
}

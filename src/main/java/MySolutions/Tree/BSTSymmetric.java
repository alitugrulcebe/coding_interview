package MySolutions.Tree;

public class BSTSymmetric {

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left,right.right) &&
                isSymmetricHelper(left.right,right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left,root.right);
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        TreeNode root = bstree.getRoot();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}

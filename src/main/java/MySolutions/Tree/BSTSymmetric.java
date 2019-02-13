package MySolutions.Tree;

public class BSTSymmetric {

    public static boolean isSymmetricHelper(BSTTreeQuestions.Node left, BSTTreeQuestions.Node right) {
        if(left == null && right == null)
            return true;

        if(left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left,right.right) &&
                isSymmetricHelper(left.right,right.left);
    }

    public static boolean isSymmetric(BSTTreeQuestions.Node root) {
        return isSymmetricHelper(root.left,root.right);
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        BSTTreeQuestions.Node root = bstree.getRoot();
        root = new BSTTreeQuestions.Node(1);
        root.left = new BSTTreeQuestions.Node(2);
        root.left.right = new BSTTreeQuestions.Node(4);
        root.right = new BSTTreeQuestions.Node(2);
        root.right.left = new BSTTreeQuestions.Node(4);
        root.left.left = new BSTTreeQuestions.Node(3);
        root.right.right = new BSTTreeQuestions.Node(3);

        System.out.println(isSymmetric(root));
    }
}

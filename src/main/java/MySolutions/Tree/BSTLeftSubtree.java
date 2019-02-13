package MySolutions.Tree;

public class BSTLeftSubtree {
    // SUM of left leaves
    public static int sumLeft(BSTTreeQuestions.Node root) {
        if(root == null ) {
            return 0;
        } else if(root.left != null && root.left.left == null && root.left.right ==null) {
            return root.left.val + sumLeft(root.right);
        } else {
            return sumLeft(root.left) + sumLeft(root.right);
        }
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        System.out.println(sumLeft(bstree.getRoot()));
    }
}

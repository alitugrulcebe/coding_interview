package MySolutions.Tree;

public class BSTHeight {
    public static int getHeight(TreeNode root) {
        if(root==null){
            return -1;
        }

        return 1 + Integer.max(getHeight(root.left),getHeight(root.right));
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        System.out.println(getHeight(bstree.getRoot()));
    }
}

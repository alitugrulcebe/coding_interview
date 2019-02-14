package MySolutions.Tree;

public class BSTMirror {
    public static TreeNode mirror(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createMirrorTree();
        TreeNode mirror = mirror(bstree.getRoot());
        PrintableTreeNode.print(mirror);
    }
}

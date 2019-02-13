package MySolutions.Tree;

public class BSTMirror {
    public static BSTTreeQuestions.Node mirror(BSTTreeQuestions.Node root) {
        if(root == null) {
            return null;
        }

        BSTTreeQuestions.Node left = mirror(root.left);
        BSTTreeQuestions.Node right = mirror(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createMirrorTree();
        BSTTreeQuestions.Node mirror = mirror(bstree.getRoot());
        PrintableTreeNode.print(mirror);
    }
}

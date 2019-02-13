package MySolutions.Tree;

public class MergeTwoTree {
    public BSTTreeQuestions.Node mergeTwoTree(BSTTreeQuestions.Node tree1, BSTTreeQuestions.Node tree2) {

        if(tree1 == null || tree2 ==null) {
            return null;
        } else {
            tree1.val += tree2.val;
            mergeTwoTree(tree1.left, tree2.left);
            mergeTwoTree(tree1.right, tree2.right);
        }
        return tree1;
    }
}

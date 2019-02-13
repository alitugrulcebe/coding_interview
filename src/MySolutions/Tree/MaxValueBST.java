package MySolutions.Tree;

public class MaxValueBST {
    public BSTTreeQuestions.Node findMaxValue(BSTTreeQuestions.Node root){
        BSTTreeQuestions.Node max;
        if(root==null){
            return null;
        } else {
            max = root;
            findMaxValue(root.right);
        }
        return max;
    }
}

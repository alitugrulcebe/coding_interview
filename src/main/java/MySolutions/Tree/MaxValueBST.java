package MySolutions.Tree;

public class MaxValueBST {
    public TreeNode findMaxValue(TreeNode root){
        TreeNode max;
        if(root==null){
            return null;
        } else {
            max = root;
            findMaxValue(root.right);
        }
        return max;
    }
}

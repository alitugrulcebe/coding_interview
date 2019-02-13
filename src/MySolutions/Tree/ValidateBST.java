package MySolutions.Tree;

public class ValidateBST {
    public boolean validateBST(BSTTreeQuestions.Node root) {
        if(root==null) {
            return true;
        }

        if(root != null) {
            if (root.left != null) {
                if (root.left.val > root.val)
                    return false;
            }
            if (root.right != null) {
                if (root.right.val < root.val) {
                    return false;
                }
            }
        }
        return validateBST(root.left) && validateBST(root.right);
    }
}

package MySolutions.Tree;

public class Traversals {
    public void postorderTraversal(TreeNode root) {
        if(root==null)
            return;
        else {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public void preorderTraversal(TreeNode root) {
        if(root==null)
            return;
        else {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void inorderTraversal(TreeNode root) {
        if(root==null)
            return;
        else {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}

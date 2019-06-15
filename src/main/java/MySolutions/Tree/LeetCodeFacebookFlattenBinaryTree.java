package MySolutions.Tree;

import MySolutions.Tree.TreeNode;

public class LeetCodeFacebookFlattenBinaryTree {
    public static void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode node = helper(root,"");
        PrintableTreeNode.print(node);

    }

    public static TreeNode helper(TreeNode root,String tab) {
        if(root == null) return null;

        TreeNode left = helper(root.left,tab + " ");
        TreeNode right = helper(root.right,tab + " ");

        if(left != null && right == null) {
            root.right = left;
            root.left = null;
        } else if(left != null && right != null) {
             TreeNode n = left;
             while(n.right!=null) {
                 n = n.right;
             }
            n.right = right;
            root.right = left;
            n.left = null;
            root.left = null;
            right.left = null;
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(6);
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        flatten(treeNode);
    }
}

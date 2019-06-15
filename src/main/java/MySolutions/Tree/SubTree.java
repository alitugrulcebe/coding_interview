package MySolutions.Tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

public class SubTree {


    public static boolean isSubtree(TreeNode s,TreeNode t) {
        if(s == null)
            return false;

        if(s.val == t.val)
            return isEqual(s,t);
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private static boolean isEqual(TreeNode s, TreeNode t) {
        if(s == null && t== null)
            return true;
        if(s.left == null && t.left != null)
            return false;

        if(s.right == null && t.right != null)
            return false;

        if(s.val != t.val)
            return false;

        return isEqual(s.left,t.left) && isEqual(s.right,t.right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        System.out.println(isSubtree(s,t));
    }
}

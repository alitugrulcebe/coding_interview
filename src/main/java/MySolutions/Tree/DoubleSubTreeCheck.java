package MySolutions.Tree;

import java.util.HashSet;
import java.util.Set;

public class DoubleSubTreeCheck {
    static final char MARKER = '$';
    static Set<String> subtrees = new HashSet<String>();
    public static boolean dupSub(TreeNode root)
    {
        subtrees.clear();

        String res = dupSubUtil(root);
        if(res.compareTo("") == 0)
            return true;
        else
            return false;
    }

    public static String dupSubUtil(TreeNode root)
    {
        String s = "";

        if(root == null)
            return s + MARKER;

        String lStr = dupSubUtil(root.left);
        if (lStr.compareTo(s) == 0)
            return s;

        String rStr = dupSubUtil(root.right);
        if (rStr.compareTo(s) == 0)
            return s;

        s = s + root.val + lStr + rStr;

        if (s.length() > 3 && subtrees.contains(s) == true)
            return "";

        subtrees.add(s);

        return s;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(dupSub(root));
    }
}

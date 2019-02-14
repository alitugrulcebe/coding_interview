package MySolutions.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTGetLeafCount {
    public static int getLeafCountIterative(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int leafCount = 0;
        while (!queue.isEmpty()) {
            TreeNode tmp = ((ArrayDeque<TreeNode>) queue).pop();

            if(tmp.left != null)
                queue.add(tmp.left);

            if(tmp.right != null)
                queue.add(tmp.right);

            if(tmp.left == null && tmp.right == null) {
                leafCount++;
            }
        }

        return leafCount;
    }

    public static int getLeafCount(TreeNode root) {
        if(root == null)
            return 0;
        int countLeaf = 0;

        if(root.left == null && root.right == null) {
            countLeaf++;
        }

        countLeaf += getLeafCount(root.left) + getLeafCount(root.right);

        return countLeaf;
    }


    public static int gethalfCount(TreeNode root)
    {
        if (root == null)
            return 0;

        int res = 0;
        if ((root.left == null && root.right != null) ||
                (root.left != null && root.right == null))
            res++;

        res += (gethalfCount(root.left)
                + gethalfCount(root.right));
        return res;
    }
}

package MySolutions.Tree;

public class FindMaxInTree {

    static int findMax(TreeNode n) {
        return n == null ? Integer.MIN_VALUE : Math.max(n.val, Math.max(findMax(n.left), findMax(n.right)));
    }
}
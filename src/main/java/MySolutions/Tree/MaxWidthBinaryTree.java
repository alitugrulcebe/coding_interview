package MySolutions.Tree;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthBinaryTree {
    static int ans;
    static Map<Integer, Integer> left;
    // En sola 0 pozisyonu atayip her seviyede sag tarafa 2n+1 seklinde posiyon atayip arada farkla width buluyor.
    // 2n+1 - 0 + 1 => 1 - 3 -7 ve withler 1 2 4 seklinde ilerliyor.
    public static int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0," ");
        return ans;
    }
    public static void dfs(TreeNode root, int depth, int pos,String indent) {
        System.out.println(indent + " Node val: " + (root!=null?root.val:"null") + " Pos: " + pos + " Depth " + depth);
        if (root == null) return;

        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);

        System.out.println(indent + " Max :" + ans);
        dfs(root.left, depth + 1, 2 * pos,indent+indent);
        dfs(root.right, depth + 1, 2 * pos + 1,indent+indent);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.right = new TreeNode(10);
        t.left.right.left = new TreeNode(12);
        t.left.right.right = new TreeNode(13);
        t.left.left = new TreeNode(3);
        t.left.left.left = new TreeNode(4);

        t.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.right.left = new TreeNode(8);
        PrintableTreeNode.print(t);
        System.out.println(widthOfBinaryTree(t));
    }
}

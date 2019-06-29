package MySolutions.Tree;

import apple.laf.JRSUIUtils;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _TreeTry {

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    l.add(0, t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }
            if (l.size() > 0)
                result.add(l.get(0));
        }
        return result;
    }

    public static void levelOrder(TreeNode root, boolean zigzag) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                System.out.print(t.val + " ");
                if (zigzag == true) {
                    if (t.right != null)
                        q.offer(t.right);
                    if (t.left != null)
                        q.offer(t.left);
                } else {
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }
            zigzag = !zigzag;
        }
    }

    static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public static int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

    public static TreeNode traverse(TreeNode root, String tab, int[] d, int s) {
        //s = 2;
        if (root == null)
            return root;

        s++;
        //System.out.println(tab + "S : " + s);
        TreeNode left = traverse(root.left, tab + "   ", d, s);
        d[0] = d[0] + 2;
        System.out.println(tab + "Val is : " + root.val + " Left is " + (left != null ? left.val : "null") + " S is " + s + " D[0] is " + d[0]);
        TreeNode right = traverse(root.right, tab + "   ", d, s);
        System.out.println(tab + "After Val is : " + root.val + " Right is " + (right != null ? right.val : "null") + " Left is " + (left != null ? left.val : "null") + " S is " + s + " D[0] is " + d[0]);

        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = BSTTreeQuestions.createBSTTree().getRoot();
//        PrintableTreeNode.print(root);
//        int[] d = new int[2];
//        d[0] = 1;
//        traverse(root," ",d,0);
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);

        //diameterOfBinaryTree(r);
        //levelOrder(r, true);
        System.out.println(rightSideView(r));
    }
}

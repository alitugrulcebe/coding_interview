package MySolutions.Tree;

import interview_questions.Tree.BST;

public class MinDiffBST {

    static Integer prev, ans;
    public static int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null)
            ans = Math.min(ans, node.val - prev);
        prev = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstTreeQuestions = BSTTreeQuestions.createBSTTree();
        minDiffInBST(bstTreeQuestions.getRoot());
    }
}

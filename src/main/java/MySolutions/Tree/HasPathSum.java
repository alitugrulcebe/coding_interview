package MySolutions.Tree;

import interview_questions.Tree.Node;

public class HasPathSum {


    static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        int pathSum = sum - root.val;
        if (root.left == null && root.right == null) {
            return pathSum == 0;
        }
        return hasPathSum(root.left,pathSum) ||
                hasPathSum(root.right,pathSum);

    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        hasPathSum(bstree.getRoot(),25);
    }
}

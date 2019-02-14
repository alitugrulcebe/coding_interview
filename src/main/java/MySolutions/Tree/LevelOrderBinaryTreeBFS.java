package MySolutions.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.List;
import java.util.Queue;

public class LevelOrderBinaryTreeBFS {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode peaked = queue.peek();
            int size = queue.size();

            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode removed = queue.remove();
                level.add(removed.val);
                if(removed.left != null) {
                    queue.add(removed.left);
                }
                if(removed.right != null) {
                    queue.add(removed.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstTreeQuestions = BSTTreeQuestions.createBSTTree();
        System.out.println(levelOrder(bstTreeQuestions.getRoot()));

    }
}

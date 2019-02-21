package MySolutions.Tree;

import java.util.*;

public class LevelOrderZigZagTwoStack {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        stack.add(root);
        boolean leftToRight = true;
        // check if stack is empty
        while (!stack.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            // pop out of stack
            TreeNode treeNode = stack.pop();

            // print the data in it
            System.out.println(treeNode.val);

            // store data according to current
            // order.
            if (leftToRight) {
                if (treeNode.left != null) {
                    next.push(treeNode.left);
                }

                if (treeNode.right != null) {
                    next.push(treeNode.right);
                }
            }
            else {
                if (treeNode.right != null) {
                    next.push(treeNode.right);
                }

                if (treeNode.left != null) {
                    next.push(treeNode.left);
                }
            }

            if (stack.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = stack;
                stack = next;
                next = temp;
            }

            result.add(l);
        }

        return result;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstTreeQuestions = BSTTreeQuestions.createBSTTree();
        System.out.print(zigzagLevelOrder(bstTreeQuestions.getRoot()));

    }
}

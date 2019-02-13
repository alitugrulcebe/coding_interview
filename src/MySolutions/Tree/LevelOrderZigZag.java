package MySolutions.Tree;

import java.util.*;

public class LevelOrderZigZag {
    public static List<List<Integer>> zigzagLevelOrder(BSTTreeQuestions.Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Stack<BSTTreeQuestions.Node> stack = new Stack<>();
        Stack<BSTTreeQuestions.Node> next = new Stack<>();
        stack.add(root);
        boolean leftToRight = true;
        // check if stack is empty
        while (!stack.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            // pop out of stack
            BSTTreeQuestions.Node node = stack.pop();

            // print the data in it
            System.out.println(node.val);

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    next.push(node.left);
                }

                if (node.right != null) {
                    next.push(node.right);
                }
            }
            else {
                if (node.right != null) {
                    next.push(node.right);
                }

                if (node.left != null) {
                    next.push(node.left);
                }
            }

            if (stack.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<BSTTreeQuestions.Node> temp = stack;
                stack = next;
                next = temp;
            }

            result.add(l);
        }

        return result;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstTreeQuestions = BSTTreeQuestions.createBSTTree();
        System.out.println(zigzagLevelOrder(bstTreeQuestions.getRoot()));

    }
}

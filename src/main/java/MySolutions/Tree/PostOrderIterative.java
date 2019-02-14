package MySolutions.Tree;

import java.util.Stack;

public class PostOrderIterative {
    public static void postOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>() ;
        Stack<Integer> values = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if(pop.left!= null) {
                stack.push(pop.left);
            }

            if(pop.right!= null) {
                stack.push(pop.right);
            }

            values.push(pop.val);
        }
        while (!values.isEmpty()) {
            System.out.print(values.pop() + " ");
        }
    }
}

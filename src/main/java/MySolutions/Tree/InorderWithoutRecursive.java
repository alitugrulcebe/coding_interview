package MySolutions.Tree;

import java.util.Stack;

public class InorderWithoutRecursive {
    void inorder(TreeNode root)
    {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

            /* Reach the left most TreeNode of the
            curr TreeNode */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.val + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
}

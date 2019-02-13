package MySolutions.Tree;

import java.util.Stack;

public class InorderWithoutRecursive {
    void inorder(BSTTreeQuestions.Node root)
    {
        Stack<BSTTreeQuestions.Node> s = new Stack<BSTTreeQuestions.Node>();
        BSTTreeQuestions.Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
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

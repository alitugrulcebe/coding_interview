package MySolutions.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    /* LEVEL ORDER */
    void reverseLevelOrder(TreeNode treeNode)
    {
        Stack<TreeNode> S = new Stack();
        Queue<TreeNode> Q = new LinkedList();
        Q.add(treeNode);

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a treeNode, we push the treeNode to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false)
        {
            /* Dequeue treeNode and make it root */
            treeNode = Q.peek();
            Q.remove();
            S.push(treeNode);

            /* Enqueue right child */
            if (treeNode.right != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(treeNode.right);

            /* Enqueue left child */
            if (treeNode.left != null)
                Q.add(treeNode.left);
        }

        // Now pop all items from stack one by one and print them
        while (S.empty() == false)
        {
            treeNode = S.peek();
            System.out.print(treeNode.val + " ");
            S.pop();
        }
    }
}

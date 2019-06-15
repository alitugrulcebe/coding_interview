package MySolutions.Tree;

public class RemoveTreeLessThanPathSizeK {

    // Utility method that actually removes the nodes which are not
    // on the pathLen >= k. This method can change the root as well.
    TreeNode removeShortPathNodesUtil(TreeNode node, int level, int k)
    {
        //Base condition
        if (node == null)
            return null;

        // Traverse the tree in postorder fashion so that if a leaf
        // node path length is shorter than k, then that node and
        // all of its descendants till the node which are not
        // on some other path are removed.
        node.left = removeShortPathNodesUtil(node.left, level + 1, k);
        node.right = removeShortPathNodesUtil(node.right, level + 1, k);

        // If root is a leaf node and it's level is less than k then
        // remove this node.
        // This goes up and check for the ancestor nodes also for the
        // same condition till it finds a node which is a part of other
        // path(s) too.
        if (node.left == null && node.right == null && level < k)
            return null;

        // Return root;
        return node;
    }

    // Method which calls the utitlity method to remove the short path
    // nodes.
    TreeNode removeShortPathNodes(TreeNode node, int k)
    {
        int pathLen = 0;
        return removeShortPathNodesUtil(node, 1, k);
    }
}

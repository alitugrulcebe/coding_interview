package MySolutions.Tree;

public class DoubleTree {
    private void doubleTree(TreeNode treeNode) {
        TreeNode oldLeft = null;

        if (treeNode == null) return;

        // do the subtrees
        doubleTree(treeNode.left);
        doubleTree(treeNode.right);

        System.out.println("################# BEFORE ################");
        System.out.println("########## OldLeft #############");
        PrintableTreeNode.print(oldLeft);
        System.out.println("########## TreeNode #############");
        PrintableTreeNode.print(treeNode);

        // duplicate this treeNode to its left
        oldLeft = treeNode.left;
        treeNode.left = new TreeNode(treeNode.val);
        treeNode.left.left = oldLeft;

        System.out.println("################# AFTER ################");
        System.out.println("########## OldLeft #############");
        PrintableTreeNode.print(oldLeft);
        System.out.println("########## TreeNode #############");
        PrintableTreeNode.print(treeNode);

    }

}

package MySolutions.Tree;

public class DoubleTree {
    private void doubleTree(BSTTreeQuestions.Node node) {
        BSTTreeQuestions.Node oldLeft = null;

        if (node == null) return;

        // do the subtrees
        doubleTree(node.left);
        doubleTree(node.right);

        System.out.println("################# BEFORE ################");
        System.out.println("########## OldLeft #############");
        PrintableTreeNode.print(oldLeft);
        System.out.println("########## Node #############");
        PrintableTreeNode.print(node);

        // duplicate this node to its left
        oldLeft = node.left;
        node.left = new BSTTreeQuestions.Node(node.val);
        node.left.left = oldLeft;

        System.out.println("################# AFTER ################");
        System.out.println("########## OldLeft #############");
        PrintableTreeNode.print(oldLeft);
        System.out.println("########## Node #############");
        PrintableTreeNode.print(node);

    }

}

package MySolutions.Tree;

public class BSTNumbersInRange {
    public static int numbersInRange(TreeNode treeNode, int start, int end) {
        if (treeNode == null) {
            return 0;
        }

        if ((treeNode.val > start) && (treeNode.val < end)) {
            return 1
                    + numbersInRange(treeNode.left, start, end)
                    + numbersInRange(treeNode.right, start, end);
        } else if (treeNode.val >= end) {
            return numbersInRange(treeNode.left, start, end);
        } else { // if (treeNode.data <= start)
            return numbersInRange(treeNode.right, start, end);
        }
    }
}

package MySolutions.Tree;

public class BSTNumbersInRange {
    public static int numbersInRange(BSTTreeQuestions.Node node, int start, int end) {
        if (node == null) {
            return 0;
        }

        if ((node.val > start) && (node.val < end)) {
            return 1
                    + numbersInRange(node.left, start, end)
                    + numbersInRange(node.right, start, end);
        } else if (node.val >= end) {
            return numbersInRange(node.left, start, end);
        } else { // if (node.data <= start)
            return numbersInRange(node.right, start, end);
        }
    }
}

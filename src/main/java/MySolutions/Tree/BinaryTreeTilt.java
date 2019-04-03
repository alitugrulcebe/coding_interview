package MySolutions.Tree;

public class BinaryTreeTilt {

    public static int findSum(TreeNode root) {
        if(root == null)
            return 0;
        return root.val + findSum(root.left) + findSum(root.right);
    }
    public static int findTilt(TreeNode root) {
        if(root == null)
            return 0;

        int left = findTilt(root.left);
        int right = findTilt(root.right);

        int leftSum = 0;
        int rightSum = 0;
        if(root.left != null)
            leftSum = findSum(root.left);
        if(root.right != null)
            rightSum = findSum(root.right);

        return Math.abs(leftSum - rightSum) + left + right;
    }

    public static void main(String[] args) {
        BSTTreeQuestions tiltTree = BSTTreeQuestions.createTiltTree();
        System.out.println(findTilt(tiltTree.getRoot()));
    }
}

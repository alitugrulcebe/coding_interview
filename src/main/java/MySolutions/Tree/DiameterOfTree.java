package MySolutions.Tree;

public class DiameterOfTree {

    public static int anyToany(TreeNode root,int[] d) {
        if(root == null) return -1;

        int left = anyToany(root.left,d);
        int right = anyToany(root.right,d);
        d[0] = Integer.max(d[0],left+right+2);
        return Integer.max(left,right) + 1;
    }

    public static void main(String[] args) {
        BSTTreeQuestions treeQuestions = BSTTreeQuestions.createDoubleTree();
        int[] d = new int[1];
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        anyToany(root,d);
        System.out.println(d[0]);
    }
}

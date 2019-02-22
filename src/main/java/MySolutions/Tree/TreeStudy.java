package MySolutions.Tree;

public class TreeStudy {


    public static void print(TreeNode root,TreeNode l,TreeNode r) {
        if(root != null)
            System.out.println("ROOT is " + root.val);
        else
            System.out.println("ROOT is NULL");

        if(l != null)
            System.out.println("LEFT is " + l.val);
        else
            System.out.println("LEFT is NULL");

        if(r != null)
            System.out.println("RIGHT is " + r.val);
        else
            System.out.println("RIGHT is NULL");
    }
    public static TreeNode explore(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = explore(root.left);
        TreeNode right = explore(root.right);
        print(root,left,right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.left.left = new TreeNode(7);
        explore(root);
    }
}

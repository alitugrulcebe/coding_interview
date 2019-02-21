package MySolutions.Tree;


public class BSTTreeQuestions{
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public static int max(int val,int val2) {
        return val>val2? val:val2;
    }

    private static int min(int val,int val2) {
        return val>val2? val2:val;
    }


    private TreeNode createNode(int val) {
        TreeNode newTreeNode = new TreeNode();
        newTreeNode.val = val;
        newTreeNode.left = null;
        newTreeNode.right = null;
        return newTreeNode;
    }

    void insertToBST(int val) {
        root = insert(root, val);
    }

    TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return createNode(val);
        } else {
            if (val < root.val) {
                root.left = insert(root.left, val);
            } else if (val > root.val) {
                root.right = insert(root.right, val);
            }
        }
        return root;
    }

    // SUM of right leaves
    public static BSTTreeQuestions createBinaryTree() {
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.root = new TreeNode(2);
        bstree.root.left = new TreeNode(3);
        bstree.root.right = new TreeNode(4);
        bstree.root.left.left = new TreeNode(5);
        bstree.root.left.right = new TreeNode(6);
        bstree.root.left.right.left = new TreeNode(7);
        bstree.root.left.right.right = new TreeNode(8);
        bstree.root.right.left = new TreeNode(12);
        bstree.root.right.right = new TreeNode(13);
        bstree.root.right.left.left = new TreeNode(20);
        bstree.root.right.left.right = new TreeNode(21);
        bstree.root.left.right.right = new TreeNode(23);
        return bstree;
    }
    public static BSTTreeQuestions createDoubleTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(2);
        bstree.insertToBST(1);
        bstree.insertToBST(3);
        return bstree;
    }


    public static BSTTreeQuestions createLeftLeavesTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(9);
        bstree.insertToBST(8);
        bstree.insertToBST(6);
        bstree.insertToBST(5);
        bstree.insertToBST(2);
        bstree.insertToBST(1);
        return bstree;
    }

    public static BSTTreeQuestions createMirrorTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(50);
        bstree.insertToBST(30);
        bstree.insertToBST(15);
        bstree.insertToBST(40);
        bstree.insertToBST(70);
        bstree.insertToBST(60);
        bstree.insertToBST(80);
        return bstree;
    }

    public static BSTTreeQuestions createCameraTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(40);
        bstree.insertToBST(15);
        bstree.insertToBST(30);
        bstree.insertToBST(20);
        bstree.insertToBST(23);
        return bstree;
    }

    public static BSTTreeQuestions createStrTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        bstree.setRoot(root);
        return bstree;
    }

    public static BSTTreeQuestions createTrimTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(3);
        bstree.insertToBST(4);
        bstree.insertToBST(0);
        bstree.insertToBST(2);
        bstree.insertToBST(1);
        return bstree;
    }
    public static BSTTreeQuestions createBSTTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(30);
        bstree.insertToBST(5);
        bstree.insertToBST(12);
        bstree.insertToBST(7);
        bstree.insertToBST(2);
        bstree.insertToBST(15);
        bstree.insertToBST(20);
        bstree.insertToBST(13);
        bstree.insertToBST(45);
        bstree.insertToBST(35);
        bstree.insertToBST(55);
        return bstree;
    }

    public static BSTTreeQuestions createNotValidBSTTree(){
        BSTTreeQuestions bstree = new BSTTreeQuestions();
        bstree.insertToBST(30);
        bstree.insertToBST(5);
        bstree.insertToBST(12);
        bstree.insertToBST(7);
        bstree.insertToBST(2);
        bstree.insertToBST(15);
        bstree.insertToBST(20);
        bstree.insertToBST(13);
        bstree.insertToBST(45);
        bstree.insertToBST(35);
        bstree.insertToBST(55);
        bstree.getRoot().right.right.val = 30;
        bstree.getRoot().left.right.right.val = 8;
        return bstree;
    }

    public static void main(String[] args) {
        /*BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        BSTTreeQuestions tree1 = BSTTreeQuestions.createBSTTree();
        BSTTreeQuestions tree2 = BSTTreeQuestions.createBSTTree();
        BSTTreeQuestions tree3 = new BSTTreeQuestions();

        TreeNode root = BSTTreeQuestions.createDoubleTree().getRoot();
        bstree.doubleTree(root);



        boolean all = false;
        if(all) {

            TreeNode[] nodes = bstree.splitBSTTree(bstree.getRoot(), 35);

            bstree.getRoot().left = new TreeNode(40);
            System.out.println(bstree.isBST(bstree.getRoot()));

            BSTTreeQuestions sumLeftTree = BSTTreeQuestions.createBSTTree();
            System.out.println(bstree.sumLeft(sumLeftTree.getRoot()));

            //TreeNode mirror = bstree.mirror(bstree.getRoot());
            BSTTreeQuestions cameraTree = BSTTreeQuestions.createCameraTree();
            System.out.println("################# Camera function starts ###########################");
            System.out.println("Min Camera is " + cameraTree.minCameraCover(cameraTree.getRoot()));

            System.out.println("Leaf count is " + bstree.getLeafCount(bstree.getRoot()));
            System.out.println("Iterative Leaf count is " + bstree.getLeafCountIterative(bstree.getRoot()));


            bstree.postOrderStack(bstree.getRoot());

            bstree.postorderTraversal(tree1.getRoot());

            System.out.println("Check triplet");
            System.out.println(bstree.checkTriplets(bstree.getRoot(), 135));

            System.out.println("Find max");
            System.out.println(bstree.findMaxValue(bstree.getRoot()));

            TreeNode n = bstree.lca(bstree.getRoot(), 7, 20);
            System.out.println("Odd numbers of tree");
            bstree.printAllOddNumbers(bstree.getRoot());
            System.out.println();
            bstree.mergeTwoTree(tree1.getRoot(), tree2.getRoot());
            System.out.println("Inorder Merged MySolutions.Tree");
            bstree.inorderTraversal(tree1.getRoot());

            System.out.println();
            System.out.println("Height is " + bstree.getHeight(bstree.getRoot()));

            System.out.println("Inorder");
            bstree.inorderTraversal(bstree.getRoot());
            System.out.println();
            System.out.println("Postorder");
            bstree.postorderTraversal(bstree.getRoot());
            System.out.println();
            System.out.println("Preorder");
            bstree.preorderTraversal(bstree.getRoot());
            System.out.println();

            System.out.println("Level Order Traversal");
            bstree.printLevelOrder(bstree.getRoot());

            System.out.println();
            System.out.println("Level Order Rec");
            bstree.printLevelRec(bstree.getRoot());

            System.out.println();
            System.out.println("Spiral Level Rec");
            bstree.printTreeSpiralRec(bstree.getRoot());

            System.out.println();
            System.out.println("Validate BST");
            System.out.println(bstree.validateBST(BSTTreeQuestions.createNotValidBSTTree().getRoot()));

            System.out.println("bitti");
        }*/
    }
}

package MySolutions.Tree;

import apple.laf.JRSUIUtils;

public class CountTreeNodes {
    public static int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int countLeafNodes(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        else
            return countLeafNodes(root.left )+
                    countLeafNodes(root.right);
    }

    public static int countLeafNodes1(TreeNode root,String indent) {
        System.out.println(indent + "CountleafNode1 is Called " + (root != null? root.val:"null"));
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            System.out.println(indent + "Leaf is found");
            return 1;
        }
        int l = countLeafNodes1(root.left,indent+indent);
        System.out.println(indent + "Left is found : " + l);
        int r = countLeafNodes1(root.right,indent+indent);
        System.out.println(indent + "Right count is " + r);

        System.out.println(indent + "Left + Right count " + (l+r)  + " is about to return owned by : " + root.val);
        return l+r;
    }

    public static int countEvenNodes(TreeNode root) {
        if(root == null)
            return 0;

        return (root.val%2 == 0?1:0) + countEvenNodes(root.left) + countEvenNodes(root.right);
    }

    public static int countEvenNodes1(TreeNode root) {
        if(root == null)
            return 0;


        int l = countEvenNodes1(root.left);
        l+=countEvenNodes1(root.right);

        if(root.val %2 == 0)
            l++;
        return l;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstTree = BSTTreeQuestions.createMirrorTree();
        bstTree = BSTTreeQuestions.createBSTTree();
        //System.out.println(countNodes(bstTree.getRoot()));
        System.out.println(countLeafNodes1(bstTree.getRoot()," "));
        //System.out.println(countEvenNodes1(bstTree.getRoot()));
    }

}

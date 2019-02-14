package MySolutions.Tree;

import static MySolutions.Tree.BSTHeight.getHeight;

public class SpiralPrint {
    public void printTreeSpiralRec(TreeNode root) {
        int height = getHeight(root);
        boolean turn = false;
        for(int i=0;i<=height;i++) {
            if(i%2==0)
                printTreeSpiralHelper(root,i,true);
            else
                printTreeSpiralHelper(root,i,false);
        }
    }

    public void printTreeSpiralHelper(TreeNode root, int level, boolean turn){
        if(level == 0 && root!=null) {
            System.out.print(root.val + " ");
            return;
        }

        if(root!=null) {
            if(turn) {
                printTreeSpiralHelper(root.left, level - 1,turn);
                printTreeSpiralHelper(root.right, level - 1,turn);
            } else {
                printTreeSpiralHelper(root.right, level - 1,turn);
                printTreeSpiralHelper(root.left, level - 1,turn);
            }
        }
    }

}

package MySolutions.Tree;

import static MySolutions.Tree.BSTHeight.getHeight;

public class LevelOrder {
    public void printLevelRec(BSTTreeQuestions.Node root) {
        int height = getHeight(root);
        for(int i=0;i<=height;i++) {
            printLevelOrderHelper(root,i);
        }
    }

    public void printLevelOrderHelper(BSTTreeQuestions.Node root, int level) {
        if(level == 0 && root != null) {
            System.out.print(root.val + " ");
            return;
        }

        if(root != null) {
            printLevelOrderHelper(root.left, level - 1);
            printLevelOrderHelper(root.right, level - 1);
        }
    }
}

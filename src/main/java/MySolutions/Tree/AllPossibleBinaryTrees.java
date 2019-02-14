package MySolutions.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBinaryTrees {


    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();

        if (N == 0) { // Empty tree, add as an null.
            res.add(null) ;
        }
        for (int numLeftTreeNodes = 0; numLeftTreeNodes < N; ++numLeftTreeNodes) {
            int numRightTreeNodes = N - 1 - numLeftTreeNodes ;
            List<TreeNode> leftSubtrees
                    = allPossibleFBT (numLeftTreeNodes);
            List <TreeNode> rightSubtrees
                    = allPossibleFBT (N - 1 - numLeftTreeNodes );
            // Generates all combinations of leftSubtrees and rightSubtrees.
            for(TreeNode nl: leftSubtrees){
                for(TreeNode nr:rightSubtrees){
                    TreeNode cur = new TreeNode(0);
                    cur.left=nl;
                    cur.right=nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = allPossibleFBT(4);
        System.out.println(treeNodes.size());

    }
}

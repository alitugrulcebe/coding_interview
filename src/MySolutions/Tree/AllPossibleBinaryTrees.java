package MySolutions.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBinaryTrees {


    public static List<BSTTreeQuestions.Node> allPossibleFBT(int N) {
        List<BSTTreeQuestions.Node> res = new ArrayList<>();

        if (N == 0) { // Empty tree, add as an null.
            res.add(null) ;
        }
        for (int numLeftTreeNodes = 0; numLeftTreeNodes < N; ++numLeftTreeNodes) {
            int numRightTreeNodes = N - 1 - numLeftTreeNodes ;
            List<BSTTreeQuestions.Node> leftSubtrees
                    = allPossibleFBT (numLeftTreeNodes);
            List <BSTTreeQuestions.Node> rightSubtrees
                    = allPossibleFBT (N - 1 - numLeftTreeNodes );
            // Generates all combinations of leftSubtrees and rightSubtrees.
            for(BSTTreeQuestions.Node nl: leftSubtrees){
                for(BSTTreeQuestions.Node nr:rightSubtrees){
                    BSTTreeQuestions.Node cur = new BSTTreeQuestions.Node(0);
                    cur.left=nl;
                    cur.right=nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<BSTTreeQuestions.Node> nodes = allPossibleFBT(4);
        System.out.println(nodes.size());

    }
}

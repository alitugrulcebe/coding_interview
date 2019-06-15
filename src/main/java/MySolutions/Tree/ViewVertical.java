package MySolutions.Tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ViewVertical {
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedHashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<Integer,ArrayList<Integer>>();
        verticalOrderTraversalHelper(A,0,0,map);
        for(Integer key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void verticalOrderTraversalHelper(TreeNode A, int level, int depth, LinkedHashMap<Integer,ArrayList<Integer>> result) {
        if(A == null) return;


        verticalOrderTraversalHelper(A.left,level-1,depth+1,result);
        System.out.println(A.val);
        if(!result.containsKey(level)) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(A.val);
            result.put(level,res);
        } else {
            ArrayList<Integer> res = result.get(level);
            res.add(depth,A.val);
            result.put(level,res);
        }

        verticalOrderTraversalHelper(A.right,level+1,depth+1,result);


    }

    public static void main(String[] args) {
        //BSTTreeQuestions bstTreeQuestions = BSTTreeQuestions.createSymmetric();

        //ArrayList<ArrayList<Integer>> arrayLists = verticalOrderTraversal(bstTreeQuestions.getRoot());
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.left.left = null;
        t.left.right = null;
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = verticalOrderTraversal(t);
        System.out.println(arrayLists);
    }
}

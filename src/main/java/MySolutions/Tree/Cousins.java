package MySolutions.Tree;

import java.util.HashMap;

public class Cousins {
    public void setValues(TreeNode root, TreeNode parent, HashMap<Integer,Integer> parents,
                          HashMap<Integer,Integer> depths, int depth) {
        if(root == null)
            return;

        parents.put(root.val,parent.val);
        depths.put(root.val,depth);
        setValues(root.left,root,parents,depths,depth+1);
        setValues(root.right,root,parents,depths,depth+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<Integer,Integer> parents = new HashMap<>();
        HashMap<Integer,Integer> depths = new HashMap<>();
        setValues(root,root,parents,depths,0);
        return parents.get(x) != parents.get(y) && depths.get(x) == depths.get(y);
    }
}

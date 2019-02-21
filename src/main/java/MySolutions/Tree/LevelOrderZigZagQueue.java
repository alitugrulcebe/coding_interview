package MySolutions.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigZagQueue {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;
        while(!queue.isEmpty()) {
            TreeNode peaked = queue.peek();
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(order)
                    levelList.add(node.val);
                else
                    levelList.add(0,node.val);  /// Buraya dikkat ilk basa ekliyor her seferinde
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(levelList);
            order = !order;
        }
        return result;
    }
}

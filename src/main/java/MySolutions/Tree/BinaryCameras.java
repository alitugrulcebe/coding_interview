package MySolutions.Tree;

public class BinaryCameras {
    /*
   ########################################################################################
   Explanation:
   Apply a recusion function dfs.
   Return 0 if it's a leaf.
   Return 1 if it's a parent of a leaf, with a camera on this node.
   Return 2 if it's coverd, without a camera on this node.

   For each node,
   if it has a child, which is leaf (node 0), then it needs camera.
   if it has a child, which is the parent of a leaf (node 1), then it's covered.

   If it needs camera, then res++ and we return 1.
   If it's covered, we return 2.
   Otherwise, we return 0.
    */
    private int count = 0;
    private static final int NOT_MONITOR = 0;
    private static final int MONITOR_BY_OTHER = 1;
    private static final int CAMERA_HERE = 2;

    public int minCameraCover(TreeNode root) {
        if (getState(root) == NOT_MONITOR) {
            count++;
        }
        return count;
    }

    private int getState(TreeNode root) {
        if (root == null) return MONITOR_BY_OTHER;
        int left = getState(root.left);
        int right = getState(root.right);

        if (left == NOT_MONITOR || right == NOT_MONITOR) {
            count++;
            return CAMERA_HERE;
        }
        if (left == CAMERA_HERE || right == CAMERA_HERE) {
            return MONITOR_BY_OTHER;
        }
        return NOT_MONITOR;
    }
    //########################################################################################
}

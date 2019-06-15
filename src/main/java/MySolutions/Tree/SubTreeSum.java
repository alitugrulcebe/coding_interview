package MySolutions.Tree;

public class SubTreeSum {

    // function to check if there exist
// any subtree with given sum
// cur_sum -. sum of current subtree
//            from ptr as root
// sum_left -. sum of left subtree
//             from ptr as root
// sum_right -. sum of right subtree
//              from ptr as root
    static boolean sumSubtreeUtil(TreeNode ptr,
                                  Integer cur_sum,
                                  int sum)
    {
        // base condition
        if (ptr == null)
        {
            cur_sum = new Integer(0);
            return false;
        }

        // Here first we go to left
        // sub-tree, then right subtree
        // then first we calculate sum
        // of all nodes of subtree having
        // ptr as root and assign it as
        // cur_sum. (cur_sum = sum_left +
        // sum_right + ptr.data) after that
        // we check if cur_sum == sum
        Integer sum_left = new Integer(0),
                sum_right = new Integer(0);
        return (sumSubtreeUtil(ptr.left, sum_left, sum) ||
                sumSubtreeUtil(ptr.right, sum_right, sum) ||
                ((cur_sum = sum_left +
                        sum_right + ptr.val) == sum));
    }

    // Wrapper over sumSubtreeUtil()
    static boolean sumSubtree(TreeNode root, int sum)
    {
        // Initialize sum of
        // subtree with root
        Integer cur_sum = new Integer( 0);

        return sumSubtreeUtil(root, cur_sum, sum);
    }
}

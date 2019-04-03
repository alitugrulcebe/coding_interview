package MySolutions.Tree;

import java.util.*;

public class PrintBinaryTreeMedium {
    public static int height(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static List<List<String>> printTree(TreeNode root) {
        // m is height
        // n odd number
        int h = height(root);
        int n = (int)Math.pow(2,h) -1;
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            List<String> row = Arrays.asList(new String[n]);
            Collections.fill(row,"");
            result.add(row);
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        q.offer(root);
        indexQ.offer(new int[] { 0, n - 1 });
        int row = -1;
        while(!q.isEmpty()) {
            row++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int[] indices = indexQ.poll();

                if (cur == null) {
                    continue;
                }

                int left = indices[0];
                int right = indices[1];
                int mid = left + (right - left) / 2;
                result.get(row).set(mid, String.valueOf(cur.val));

                q.offer(cur.left);
                q.offer(cur.right);
                indexQ.offer(new int[] { left, mid - 1 });
                indexQ.offer(new int[] { mid + 1, right });
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BSTTreeQuestions printBinaryTreeMedium = BSTTreeQuestions.createPrintBinaryTreeMedium();
        List<List<String>> lists = printTree(printBinaryTreeMedium.getRoot());
        System.out.println(lists);
    }
}

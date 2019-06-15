package MySolutions.Tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _PreOrderIterative {

    public  static List<Integer> preOrderTraversal(TreeNode root) {
        Deque<TreeNode> path = new LinkedList<>();
        path.addFirst(root);
        List<Integer> result = new ArrayList<>();
        while(!path.isEmpty()) {
            TreeNode node = path.removeFirst();
            if(node != null) {
                result.add(node.val);
                path.addFirst(node.right);
                path.addFirst(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        System.out.println(preOrderTraversal(root));
    }
}

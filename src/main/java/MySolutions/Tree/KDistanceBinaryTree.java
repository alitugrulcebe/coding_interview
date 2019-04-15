package MySolutions.Tree;

import java.util.*;

public class KDistanceBinaryTree {

    public static List<Integer> distanceK(TreeNode treeRoot, TreeNode startNode, int targetDistance) {
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap();
        populateNodeToParentMap(nodeToParentMap, treeRoot, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(startNode);

        Set<TreeNode> seen = new HashSet();
        seen.add(startNode);

        int currentLayer = 0;
        while (!queue.isEmpty()) {
            if (currentLayer == targetDistance) {
                return extractLayerFromQueue(queue);
            }
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }
                TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                }
            }
            currentLayer++;
        }
        return new ArrayList<Integer>();
    }

    private static void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap,
                                         TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        nodeToParentMap.put(root, parent);
        populateNodeToParentMap(nodeToParentMap, root.left, root);
        populateNodeToParentMap(nodeToParentMap, root.right, root);
    }

    private static List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
        List<Integer> extractedList = new ArrayList();
        for (TreeNode node: queue) {
            extractedList.add(node.val);
        }
        return extractedList;
    }

    public static void main(String[] args) {
        BSTTreeQuestions bstree = BSTTreeQuestions.createBSTTree();
        System.out.println(distanceK(bstree.getRoot(),bstree.getRoot().left,3));
    }
}

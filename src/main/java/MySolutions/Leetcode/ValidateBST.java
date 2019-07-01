/**
 * 
 */
package MySolutions.Leetcode;

import java.util.Stack;

/**
 * Created by Wenqi Zhu
 * 4:18:15 PM Sep 18, 2012
 * @SanFrancisco
 * LeetCode Problems
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
       return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
	public boolean isValid(TreeNode root,int min,int max){
		if(root == null) return true;
		if(root.val<=min || root.val>=max) return false;
		
		if(isValid(root.left,min,root.val) && isValid(root.right,root.val,max)) return true;
		return false;
	}

	public boolean isValidBSTIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack();
		double inorder = - Double.MAX_VALUE;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (root.val <= inorder) return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

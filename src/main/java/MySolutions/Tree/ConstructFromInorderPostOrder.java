package MySolutions.Tree;

import com.google.common.primitives.Ints;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructFromInorderPostOrder {
    /*public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length ==0)
            return null;
        Integer rootVal = postorder[postorder.length-1];
        int mid = Arrays.stream(inorder).boxed().collect(Collectors.toList()).indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(root.left,Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTreeHelper(root.right,Arrays.copyOfRange(inorder,mid + 1,inorder.length));
        return root;
    }

    private static TreeNode buildTreeHelper(TreeNode root, int[] arr) {
        if(arr.length <= 1) {
            if(arr.length > 0)
                return new TreeNode(arr[0]);
            else
                return null;
        }
        int mid = arr.length/2;
        root = new TreeNode(arr[mid]);

        root.left = buildTreeHelper(root.left,Arrays.copyOfRange(arr,0,mid));
        root.right = buildTreeHelper(root.right,Arrays.copyOfRange(arr,mid+1,arr.length));
        return root;
    }*/

    static class Index {
        int index;
    }

    static TreeNode buildUtil(int in[], int post[], int inStrt,
                   int inEnd, Index pIndex,String indent)
    {
        System.out.println(indent + "Start : " + inStrt + " End " + inEnd);
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Postrder traversal using
           postIndex and decrement postIndex */
        TreeNode node = new TreeNode(post[pIndex.index]);
        (pIndex.index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;

        /* Else find the index of this node in Inorder
           traversal */
        int iIndex = search(in, inStrt, inEnd, node.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex,indent + "  ");
        node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex, indent + "  ");

        return node;
    }

    // This function mainly initializes index of root
    // and calls buildUtil()
    static TreeNode buildTree(int in[], int post[], int n)
    {
        Index pIndex = new Index();
        pIndex.index = n - 1;
        TreeNode t=  buildUtil(in, post, 0, n - 1, pIndex," ");
        return t;
    }

    /* Function to find index of value in arr[start...end]
       The function assumes that value is postsent in in[] */
    static int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        buildTree(new int[]{4, 8, 2, 5, 1, 6, 3, 7}, new int[]{8, 4, 5, 2, 6, 7, 3, 1},8);
    }
}

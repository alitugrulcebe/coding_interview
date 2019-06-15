package MySolutions.Tree;

public class AllPossibleBST {
  /*
 For the key values 1...numKeys, how many structurally unique
 binary search trees are possible that store those keys.
 Strategy: consider that each value could be the root.
 Recursively find the size of the left and right subtrees.
*/
  static int countTrees(int numKeys,String tab,String caller) {

    if (numKeys <=1) {
      System.out.println(tab + " Caller " + caller);
      return(1);
    }
    else {
      // there will be one value at the root, with whatever remains
      // on the left and right each forming their own subtrees.
      // Iterate through all the values that could be the root...
      int sum = 0;
      int left, right, root;

      for (root=1; root<=numKeys; root++) {
        System.out.println(tab + "Loop in " + root + " Numkey "+ numKeys + " Caller " + caller);
        left = countTrees(root - 1,tab + " ","left");
        System.out.println(tab + " Returned left is " + left + " Caller " + caller);
        right = countTrees(numKeys - root, tab+ " ","right");
        System.out.println(tab + "Left :" + left);
        System.out.println(tab + "Right :" + right);
        // number of possible trees with this root == left*right
        sum += left*right;
      }

      return(sum);
    }
  }

  public static void main(String[] args) {
    System.out.println(countTrees(3," ","root"));
  }
}

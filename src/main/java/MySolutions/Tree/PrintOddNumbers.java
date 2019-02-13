package MySolutions.Tree;

public class PrintOddNumbers {

    public void printAllOddNumbers(BSTTreeQuestions.Node root) {
        if(root == null)
            return;

        printAllOddNumbers(root.left);
        if(root.val%2!=0)
            System.out.print(root.val + " ");
        printAllOddNumbers(root.right);
    }
}

package MySolutions.Tree;

public class SplitVST {
    public BSTTreeQuestions.Node[] splitBSTTree(BSTTreeQuestions.Node root, int V) {
        BSTTreeQuestions.Node[] rootList = new BSTTreeQuestions.Node[] {null,null};
        if(root == null)
            return rootList;

        if(root.val <= V) {
            rootList = splitBSTTree(root.right,V);
            root.right = rootList[0];
            rootList[0] = root;
        } else {
            rootList = splitBSTTree(root.left,V);
            root.left = rootList[1];
            rootList[1] = root;
        }
        return rootList;
    }

}

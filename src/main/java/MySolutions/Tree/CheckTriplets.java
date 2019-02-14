package MySolutions.Tree;

import java.util.ArrayList;
import java.util.List;

public class CheckTriplets {
    public void getNodeValuesInOrder(TreeNode root, List<Integer> list) {
        if(root== null) {
            return;
        } else {
            getNodeValuesInOrder(root.left,list);
            list.add(root.val);
            getNodeValuesInOrder(root.right,list);
        }
    }

    public boolean checkTriplets(TreeNode root, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        getNodeValuesInOrder(root,list);

        for(int i=0;i<list.size();i++) {
            int moveId = i + 1;
            int end = list.size()-1;
            while(moveId<end){
                if(list.get(i) + list.get(moveId) + list.get(end) == sum)
                    return true;
                else if(list.get(i) + list.get(moveId) + list.get(end) < sum)
                    moveId++;
                else
                    end--;
            }
        }
        return false;
    }
}

package MySolutions.Tree;

import java.util.ArrayList;
import java.util.List;

class _ConstructFromPreorderSpecial
{
    static int index = 0;
    public static TreeNode recoverFromPreorderRec(String S) {
        return helper(S, 0);
    }

    public static TreeNode helper(String s, int depth) {
        int numDash = 0;
        while (index + numDash < s.length() && s.charAt(index + numDash) == '-') {
            numDash++;
        }
        if (numDash != depth) return null;
        int next = index + numDash;
        while (next < s.length() && s.charAt(next) != '-') next++;
        int val = Integer.parseInt(s.substring(index + numDash, next));
        index = next;
        TreeNode root = new TreeNode(val);
        root.left = helper(s, depth + 1);
        root.right = helper(s, depth + 1);
        return root;
    }

    public static TreeNode recoverFromPreorder(String S) {
        String[] tokens = S.split("-");
        List<TreeNode> list = new ArrayList<>();

        list.add(new TreeNode(Integer.valueOf(tokens[0])));
        int level = 1;
        for(int i=1; i<tokens.length; i++){

            if(!tokens[i].isEmpty()){
                TreeNode node = new TreeNode(Integer.valueOf(tokens[i]));
                list.add(level, node);

                TreeNode parent = list.get(level-1);
                if(parent.left == null){
                    parent.left  = node;
                }else{
                    parent.right = node;
                }

                level = 1;
            }else{
                level++;
            }
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        recoverFromPreorder("1-2--3--4-5--6--7");
    }
}

// This code has been contributed by Mayank Jaiswal


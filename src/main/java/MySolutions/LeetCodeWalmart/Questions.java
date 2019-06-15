package MySolutions.LeetCodeWalmart;



import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Questions {

//    Check if there exist two elements in an array whose sum is equal to the sum of rest of the array
//    Input  : arr[] = {2, 11, 5, 1, 4, 7}
//    Output : Elements are 4 and 11
//    Note that 4 + 11 = 2 + 5 + 1 + 7
//
//    Input  : arr[] = {2, 4, 2, 1, 11, 15}
//    Output : Elements do not exist
//
//2 11 = 13
//    rest = 17
//
//            11 5 = 16
//    rest = 14
//
//    public List<Integer> findElements(int[] arr) {
//        int sum = 0;
//        for(int i=0;i<arr.length;i++)
//            sum += arr[i];
//
//        HashMap<Integer,Pair<Integer,Integer>> map = new HashMap<>();
//        for(int i=0,j=1; i<arr.length;i++) {
//            int s = arr[i] + arr[j];
//            if(i != arr.length-1)
//                j++;
//            int rest = sum - s;
//            if(!map.containsKey(rest))
//                map.put(rest,new Pair(i,j));
//        }
//        List<Integer> result = new ArrayList<>();
//        Pair<Integer,Integer> p
//        for(int i=0;i<arr.length-1;i++) {
//            int sum = arr[i] + arr[i+1];
//            if(map.containsKey(sum)) {
//                p = map.get(sum);
//                break;
//            }
//        }
//
//        for(int i=0;i<arr.length-1;i++) {
//            if(i != p.first || i != p.second)
//                result.add(i);
//        }
//        return result;
//    }
//
//
//    _________________________________________________________________________________________________________
//
//    Given an binary Tree Print the Line by line
//
//       1
//               /  \
//               0    3
//               /\   / \
//               4  5  9  7
//               / \
//               6  15
//
//    output ::
//            1
//            0 3
//            4 5 9 7
//            6 15
//
//    public void printLevelByLevel(TreeNode tree) {
//        if(tree == null) return;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(tree);
//
//        while(!queue.isEmpty()) {
//            int size = q.size();
//            for(int i=0;i<size;i++) {
//                TreeNode t = q.poll();
//                System.out.print(t.value);
//
//                if(t.left != null)
//                    q.offer(t.left);
//
//                if(t.right != null)
//                    q.offer(t.right);
//            }
//            System.out.println();
//        }
//
//    }
//
//
//    _________________________________________________________________________________________________________
//    Core Java (7/10)
//    Object class?
//    methods of object class? equals, hashing, tostring
//
//    Immutable classes?
//    String str1 = "Hey Ali";
//    String str2 = new String ("Hey Ali");
//    String str3 = "Hey Ali";
//
//try {
//        int i=10/0;
//    } catch (Exception e){
//        e.printStackTrace();
//    } catch (ArithmeticException ae){
//        ae.printStackTrace();
//    }
//
//
//    @RestController
//    @EnableEurokaDiscovery
//    public class ShoppingConroller
//
//    @Autowired
//    ShoppingRepository repository;
//
//    @GetMapping
//    public ResponseEntity<String> retrieveShoppingCart(@PathParam String id) {
//
//
//    }

    public static List<Integer> findElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        HashMap<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0, j = 1; i < arr.length-1; i++) {
            int s = arr[i] + arr[j];

            int rest = sum - s;
            if (!map.containsKey(rest))
                map.put(rest, new Pair(i, j));
            if (i < arr.length - 2)
                j++;
        }
        List<Integer> result = new ArrayList<>();
        Pair<Integer, Integer> p = null;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum1 = arr[i] + arr[i + 1];
            if (map.containsKey(sum1)) {
                p = map.get(sum1);
                break;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (i != p.getKey() || i != p.getValue())
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        findElements(new int[]{2, 11, 5, 1, 4, 7});
    }
}

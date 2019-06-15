package MySolutions.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Ex1 {

    public static String reverse(String s) {
        if(s.isEmpty()) return s;
        //Collections
        return reverse(s.substring(1,s.length())) + s.substring(0,1);
    }
    static void recurse(int[] list, int num) {
        if(num == 5) {  // print if condition is true
            print("Reached num = 5", list, num);
            return;
        }
        list[num] = num;
        recurse(list,num+1);
        print("After recursive call returns ", list, num);// check elements in array
    }

    static void recurse(ArrayList<Integer> list, int num) {
        if(num == 5) {  // print if condition is true
            print("Reached num = 5", list);
            return;
        }
        list.add(num);
        recurse(list,num+1);
        print("After recursive call returns ", list); // check element of Arraylist
    }
    private static void print(String msg, ArrayList<Integer> list) {
        System.out.println(msg);
        System.out.println(list);
    }
    private static void print(String msg, int[] list, int index) {
        System.out.println(msg);
        for(int i = 0 ; i < index; ++i)
            System.out.printf("%d ", list[i]);
        System.out.println();
    }

    public static void main(String[] args) {
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        recurse(arr1,0);
//        int[] arr2 = new int[12];
//        recurse(arr2,0);

        System.out.println(reverse("ahmet"));
    }
}

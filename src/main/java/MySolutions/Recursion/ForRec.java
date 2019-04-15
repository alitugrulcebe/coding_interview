package MySolutions.Recursion;

public class ForRec {
    static int x = 0;
    public static void doAnagram(int newSize,String indent,int ii) {

        if (newSize == 1) {
            System.out.println(indent + "Top NewSize " + newSize + " I is " + ii + " Returning");
            return;
        }
        for (int i = 0; i < newSize; i++) {
            x++;
            System.out.println(indent + "Before NewSize " + newSize + " I is " + i);
            doAnagram(newSize - 1, indent + "   ",i);
            System.out.println(indent + "After NewSize " + newSize + " I is " + i);
        }
    }

    public static void main(String[] args) {
        doAnagram(4," ",-1);
        System.out.println("Total " + x);
    }
}

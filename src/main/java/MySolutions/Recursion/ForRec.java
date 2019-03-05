package MySolutions.Recursion;

public class ForRec {
    public static void doAnagram(int newSize,String indent) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            System.out.println(indent + "Before NewSize " + newSize + " I is " + i);
            doAnagram(newSize-1, indent + "   ");
            System.out.println(indent + "After NewSize " + newSize + " I is " + i);
        }
    }

    public static void main(String[] args) {
        doAnagram(4," ");
    }
}

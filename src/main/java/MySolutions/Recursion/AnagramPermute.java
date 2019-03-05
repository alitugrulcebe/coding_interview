package MySolutions.Recursion;

public class AnagramPermute {
    public static void doAnagram(char[] A,int newSize) {
        if(newSize == 1) {
            return;
        }
        for(int i=0;i<newSize;i++) {
            doAnagram(A,newSize-1);
            if(newSize == 2)
                System.out.println(A);
            rotate(A,newSize);
        }
    }

    private static void rotate(char[] a, int newSize) {
        int j;
        int pos = a.length - newSize;
        char tmp = a[pos];
        for(j=pos+1;j<a.length;j++) {
            a[j-1] = a[j];
        }
        a[j-1] = tmp;
    }

    public static void main(String[] args) {
        doAnagram("cats".toCharArray(),4);
    }
}

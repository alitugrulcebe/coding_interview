package MySolutions.Recursion;

public class RecDeneme {

    public static void swap(char[] str,int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(new String(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }

    public static void main(String[] args) {

        perm2("abcd".toCharArray(),4);

    }
}

package MySolutions.BitManipulation;

public class Examples {
    public static void main(String[] args) {
        String str = "abcde";
        int a =  1 << str.length();
        System.out.println(a);
        int b =  1 << 3;
        System.out.println(b);
        int e = 20 >> 1;
        System.out.println(e);

        int c = 14 ^ 5;
        System.out.println(c);
        int d = 14 | 5;
        System.out.println(d);

        int i = 5;
        int j = 7;
        int x = i & j;
        System.out.println(x);
    }
}

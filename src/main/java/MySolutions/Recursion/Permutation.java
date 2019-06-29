package MySolutions.Recursion;

public class Permutation {

    public static void permute(String s, String t) {
        if(s.isEmpty())
            System.out.println(t);

        for(int i=0;i<s.length();i++) {
            t += s.charAt(i);
            String newS = new StringBuilder(s).deleteCharAt(i).toString();
            permute(newS,t);
            t = t.substring(0,t.length()-1);
        }
    }

    public static void recPermute(String soFar, String remaining) {
        //base case
        if (remaining.length() == 0)
            System.out.println(soFar);
        else {
            for (int i=0; i< remaining.length(); i++) {
                String nextSoFar = soFar + remaining.charAt(i);
                String nextRemaining = remaining.substring(0,i) + remaining.substring(i+1);
                recPermute(nextSoFar, nextRemaining);
            }
        }
    }

    // print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++) {
                String s1 = prefix + s.charAt(i);
                String s2 = s.substring(0, i) + s.substring(i + 1, n);
                perm1(s1, s2);
            }
        }

    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
        perm2(a, n);
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

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



    public static void main(String[] args) {
        int n = 3;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        //perm1(elements);
        System.out.println();
        //perm2(elements);
        //permute("ABC","");
        recPermute("","ABC");
    }
}
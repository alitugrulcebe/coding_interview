package MySolutions.Recursion;

public class RecursiveString {

    static String reverse(String s) {
        if(s.length() == 0)
            return s;
        String first = "" + s.charAt(0);
        return reverse(s.substring(1)) + first;
    }

    public static void main(String[] args) {
        String str = reverse("deneme");
        System.out.println(str.substring(1));
        System.out.println(str);
    }
}

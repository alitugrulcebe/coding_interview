package MySolutions.Recursion;

public class ReverseString {
    public static String reverseString(String s) {
        if(s.isEmpty())
            return "";

        String sub = s.substring(1,s.length());
        char prefix = s.charAt(0);
        return reverseString(sub) + prefix;

    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcd"));
    }
}

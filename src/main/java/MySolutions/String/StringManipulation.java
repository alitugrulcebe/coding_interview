package MySolutions.String;

import java.util.*;
import java.util.stream.Stream;

public class StringManipulation {
    public static void main(String[] args) {
        String s = "abcd";
        char[] chars = s.toCharArray();
        char c = s.charAt(0);
        String substring = s.substring(0, s.length());
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        sb.deleteCharAt(0);
        String s1 = sb.toString();

        char[] chars1 = Arrays.copyOf(s.toCharArray(), s.length());
        boolean digit = Character.isDigit(s.charAt(0));
        int digi1t = Character.digit(s.charAt(0),10);

        String strArray[] = s.split("");
        List<String> list = Arrays.asList(s);
        Collections.sort(list);
        Arrays.sort(strArray,Collections.reverseOrder());

        Hashtable<Integer,Integer> table = new Hashtable<>();
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<Integer,Integer> map = new LinkedHashMap<>();


    }
}

package MySolutions.String;

public class Pangram {
    private static final int MAX_CHAR = 26;
    // Returns characters that needs to be added
    // to make str
    public static String missingChars(String strArray) {
        // A boolean array to store characters
        // present in string.
        boolean[] present =new boolean[MAX_CHAR];
        char[] str = strArray.toCharArray();
        // Traverse string and mark characters
        // present in string.
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= 'a' && str[i] <= 'z')
                present[str[i] - 'a'] = true;
            else if (str[i] >= 'A' && str[i] <= 'Z')
                present[str[i] - 'A'] = true;
        }

        // Store missing characters in alphabetic
        // order.
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < MAX_CHAR; i++)
            if (!present[i])
                res.append((char) (i + 'a'));

        return res.toString();
    }

    // Driver program
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the dog";
        System.out.println(missingChars(str));
    }
}

package MySolutions.LeetCodeGoogleExplore;

public class LongestSubstringNonRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        for(int i=0; i<s.length(); i++) {
            if(max <= s.length() - i) {
                max = Math.max(max, maxNonRepeat(i, s));
            }
        }

        return max;
    }

    public static int maxNonRepeat(int idx, String s) {
        String aux = "";
        int c = 0;
        for(int i=idx; i<s.length(); i++) {
            if(aux.indexOf(s.charAt(i)) == -1) {
                aux += s.charAt(i);
                c++;
            } else {
                return c;
            }
        }

        return c;
    }

    public static void main(String[] args) {
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

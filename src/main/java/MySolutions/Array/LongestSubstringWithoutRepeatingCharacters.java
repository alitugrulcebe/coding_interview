package MySolutions.Array;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring1(String s) {
        // need index of each character so we can reset startIndex to the right index
        HashMap<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        int longest = 0;

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && startIndex < map.get(s.charAt(i)) + 1) {
                startIndex = map.get(s.charAt(i)) + 1;
            }
            longest = Math.max(endIndex - startIndex+1, longest);
            map.put(s.charAt(i), i);
            endIndex++;
        }

        return longest;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;

        for(int i=0; i<s.length(); i++) {
            if(max <= s.length() - i) {
                max = Math.max(max, maxNonRepeat(i, s));
            }
        }

        return max;
    }

    public int maxNonRepeat(int idx, String s) {
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
}

package MySolutions.LeetCodeGoogleExplore;

import java.util.HashMap;
import java.util.TreeMap;

public class MinimumWindowSubstring {
  /**
   * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
   * <p>
   * Example:
   * <p>
   * Input: S = "ADOBECODEBANC", T = "ABC"
   * Output: "BANC"
   * Note:
   * <p>
   * If there is no such window in S that covers all characters in T, return the empty string "".
   * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
   * <p>
   * Basically it's a problem of sliding window. The brief algorithm is:
   * <p>
   * Use start/end pointer to indicate current valid window.
   * Go through the string s by moving forward the end pointer.
   * For each step, try to move forward the start pointer to see if we can still get a valid window.
   * Remember the minimum window and return it.
   * The key point is, how to determine if current window is valid (containing all the characters in string t). Brute force is obviously too slow. A solution is to use two tools:
   * <p>
   * Use a HashMap to remember "how many times for a character we need to match the requirement". e.g. for char "a", the number 1 means we need to meet "a" once more in the target string s, 0 means we have met it exactly, and -1 means "we can tolerate losing it once more but still matching the requirement".
   * Use a int count to remember "how many valid characters we have gotten". If count == s.length(), it means we have gotten all characters needed and current window is valid.
   * By the tools, the algorithm is:
   * <p>
   * Go through the string t, and calculate "how many times for a character we need to match the requirement".
   * Go through the string s, and for each character: if the map contains the character, decrease the relevant value because "we have met the one". In addition, if value >= 0, increase count because "we have gotten one valid character just now". Note that we don't need to update count if value < 0, because it means "we have gotten more times than needed for the character" and doesn't impact count.
   * For each step of the loop, we need to try to move forward the start pointer to see if we can still get a valid window. If the map contains the character, increase the relevant value because "we lose the character". In addition, if value > 0, decrease count because "we have lost one valid character just now". Again, we don't need to update count if value <= 0, because it means "we have lost the character once, but the rest can still match the requirement".
   * Update res when we never update res before (res.length() == 0) or we got a smaller window (i - start + 1 < res.length()).
   * I am glad to answer any question about the algorithm...
   **/

  public static String minWindow(String s, String t) {
    int start = 0, count = 0;
    String res = "";
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < t.length(); i++) {
      char chr = t.charAt(i);
      map.put(chr, map.getOrDefault(chr, 0) + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      char chr = s.charAt(i);
      if (map.containsKey(chr)) {
        map.put(chr, map.get(chr) - 1);
        if (map.get(chr) >= 0) count++;
      }
      while (count == t.length()) {
        if (res.length() == 0 || (i - start + 1 < res.length())) res = s.substring(start, i + 1);
        chr = s.charAt(start);
        if (map.containsKey(chr)) {
          map.put(chr, map.get(chr) + 1);
          if (map.get(chr) > 0) count--;
        }
        start++;
      }
    }
    return res;
  }


  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
}

package MySolutions.LeetCodeAmazonExplore.MockInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q1 {

    public static String mostCommonWord(String p, String[] banned) {
        if(p.length() < 1 || p.length() > 1000) return "";
        HashMap<String,Integer> map = new HashMap();
        List<String> words = new ArrayList<>();
        String s = "";
        for(int i=0;i<p.length();i++) {
            if(p.charAt(i) != '!' ||
                    p.charAt(i) != '?' ||
                    p.charAt(i) != '\'' ||
                    p.charAt(i) != '\\' ||
                    p.charAt(i) != ';' ||
                    p.charAt(i) != '.') {
                s += p.charAt(i);
            } else {
                if(!s.isEmpty())
                    words.add(s);
                s = "";
            }
        }
        List<String> bannedList = Arrays.asList(banned);
        for(String w:words) {
            w = w.toLowerCase();
            String fw = "";
            for(int i=0;i<w.length();i++) {
                if(Character.isLetter(w.charAt(i))) {
                    fw += w.charAt(i);
                }
            }
            if(!bannedList.contains(fw)) {
                map.put(fw,map.getOrDefault(fw,0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        String result = "";
        for(String k:map.keySet()) {
            if(map.get(k) > max) {
                max = map.get(k);
                result = k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"});
    }
}

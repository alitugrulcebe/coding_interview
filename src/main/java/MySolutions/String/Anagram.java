package MySolutions.String;

import java.util.*;

import static java.util.Arrays.asList;

public class Anagram {

    public static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        HashMap<String,Integer> freqA = new HashMap();
        for (char c : aChars) {
            String key = c + "";
            if(freqA.containsKey(key)) {
                Integer val = freqA.get(key);
                freqA.put(key, ++val);
            }
            else {
                freqA.put(key, 1);
            }
        }

        HashMap<String,Integer> freqB = new HashMap();
        for (char c : bChars) {
            String key = c + "";
            if(freqB.containsKey(key)) {
                Integer val = freqB.get(key);
                freqB.put(key, ++val);
            }
            else {
                freqB.put(key, 1);
            }
        }

        HashMap<String,Integer> freq = freqA.size()>freqB.size() ? freqA : freqB;
        HashMap<String,Integer> otherFreq = freqA.size()>freqB.size() ? freqB : freqA;

        for(String key:freq.keySet()){
            if(!otherFreq.containsKey(key))
                return false;
        }

        for(String key:freq.keySet()){
            if(freqA.get(key) != freqB.get(key))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean ret = isAnagram("ab", "abXY");
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

        List<Integer> numbers = asList(1, 1, 2, 1, 6, 3, 5);
        System.out.println("Numbers: " + numbers);

// Use LinkedHashSet if you want to preserve order
        Set<Integer> unique = new LinkedHashSet<>(numbers);
        numbers = new ArrayList<>(unique);
        System.out.println("Unique: " + numbers);


    }
}

package MySolutions.String;

import java.util.HashSet;
import java.util.Set;

public class Mors {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mors = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set =new HashSet<>();
        for(String w:words) {
            char[] chars = w.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<chars.length;i++) {
                int c = chars[i] - 'a';
                sb.append(mors[c]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}

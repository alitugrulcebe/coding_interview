package MySolutions.LeetCodeAmazonExplore.Contest;

import java.util.ArrayList;
import java.util.List;

public class Contest140 {
    //Occurences After Bigram
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] words= text.split(" ");

        for(int i=0;i<words.length;i++) {
            if(i < words.length-2) {
                if(words[i].compareTo(first) == 0 &&
                        words[i+1].compareTo(second) == 0)
                    result.add(words[i+2]);
            }
        }

        return result.stream().toArray(String[]::new);
    }
}

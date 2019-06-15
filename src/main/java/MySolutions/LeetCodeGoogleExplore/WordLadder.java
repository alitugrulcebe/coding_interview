package MySolutions.LeetCodeGoogleExplore;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        boolean found = false;
        int ladderLength = 0;
        //while(true) {
        for(int i=0;i<wordList.size();i++) {
            String word = wordList.get(i);
            if(word.length() == beginWord.length() && !word.equals(beginWord)) {
                char[] bChars = beginWord.toCharArray();
                char[] wChars = word.toCharArray();
                int diff = 0;
                for(int j=0;j<bChars.length;j++) {
                    if (bChars[j] != wChars[j])
                        diff++;
                }
                if(diff == 1) {
                    beginWord = word;
                    ladderLength++;
                    wordList.remove(word);
                    i = 0;
                }
                if(beginWord.equals(endWord)) {
                    return ladderLength;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        list.add("dot");
        ladderLength("hot","dog",list);
    }
}

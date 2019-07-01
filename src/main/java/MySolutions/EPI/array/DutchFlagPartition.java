package MySolutions.EPI.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlagPartition {
    public static enum Color {RED, WHITE, BLUE}


    public static void dutchFlagPartition(int pivotlndex, List<Color> A) {
        Color pivot = A.get(pivotlndex);
        int smaller = 0, equal = 0, larger = A.size();
        while(equal < larger) {
            if(A.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(A,smaller++,equal++);
            } else if(A.get(equal).ordinal() == pivot.ordinal()) {
                equal++;
            } else {
                Collections.swap(A,equal,--larger);
            }
        }
    }

    public static void main(String[] args) {
        List<Color> colors = Arrays.asList(Color.RED,
                Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE, Color.WHITE);
        dutchFlagPartition(2, colors);
        System.out.println(colors);
    }
}

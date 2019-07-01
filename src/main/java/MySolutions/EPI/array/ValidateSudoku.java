package MySolutions.EPI.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateSudoku {

    public static boolean isValidSudoku(List<List<Integer>> partialAssignments){
        //Check row constraints
        for (int i = 0; i < partialAssignments.size() ; i++) {
            if(hasDuplicate(partialAssignments,i,i+1,0,partialAssignments.size())) {
                return false;
            }
        }

        //Check column constraints
        for (int i = 0; i < partialAssignments.size() ; i++) {
            if(hasDuplicate(partialAssignments,0,partialAssignments.size(),i,i+1)) {
                return false;
            }
        }

        //Check region constraints
        int regionSize = (int)Math.sqrt(partialAssignments.size());
        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize ; j++) {
                if(hasDuplicate(partialAssignments, regionSize * i, regionSize * (i+1),
                        regionSize * j, regionSize * (j+1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasDuplicate(List<List<Integer>> partialAssignments, int startRow, int endRow,
                                        int startColumn, int endColumn) {
        List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialAssignments.size()+ 1,false));
        for (int i = startRow; i < endRow ; i++) {
            for (int j = startColumn; j < endColumn ; j++) {
                if(partialAssignments.get(i).get(j) != 0 &&
                isPresent.get(partialAssignments.get(i).get(j))) {
                    return true;
                }
                isPresent.set(partialAssignments.get(i).get(j),true);
            }
        }
        return false;
    }
}

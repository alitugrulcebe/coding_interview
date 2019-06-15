package MySolutions.LeetCodeGoogleExplore;

public class OddEvenJump {

    public static int oddEvenJumps(int[] A) {

        int startingIndex = 0;
        int counter = 0;
        while(startingIndex < A.length) {
            if(isValid(A,startingIndex))
                counter++;
            startingIndex++;
        }
        return counter;
    }

    public static boolean isValid(int[] A,int sIndex) {
        if(sIndex == A.length -1)
            return true;
        int next = sIndex;
        boolean oddJump = true;
        while(sIndex < A.length) {
            next = findNextJumpIndex(A,next,oddJump);
            oddJump = !oddJump;
            if(next == A.length-1)
                return true;
             else if(next > A.length)
                 return false;
             else if(next == -1)
                 return false;
        }
        return false;
    }

    public static int findNextJumpIndex(int[] A,int index,boolean oddJump) {
        if(oddJump) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i=A.length-1;i>index;i--) {
                if(A[i] <= min && A[i] >= A[index] ) {
                    min = A[i];
                    minIndex = i;
                }
            }
            return minIndex;
        } else {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for(int i=A.length-1;i>index;i--) {
                if(A[i] >= max && A[i] <= A[index] ) {
                    max = A[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

    }

    public static void main(String[] args) {
        //System.out.println(oddEvenJumps(new int[]{10,13,12,14,15}));
        System.out.println(oddEvenJumps(new int[]{2,3,1,1,4}));
    }
}

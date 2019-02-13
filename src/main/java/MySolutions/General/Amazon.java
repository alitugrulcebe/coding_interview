package MySolutions.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Amazon {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        int leftSide = 0;
        int rightSide = 0;
        for (int j=0; j<days; j++) {
            int [] statesTemp = new int[states.length];
            for (int i=0; i<states.length; i++) {
                if (i == 0) {
                    if (states[i + 1] == leftSide) {
                        statesTemp[i] = 0;
                    } else {
                        statesTemp[i] = 1;
                    }
                } else if (i == states.length - 1) {
                    if (states[i - 1] == rightSide) {
                        statesTemp[i] = 0;
                    } else {
                        statesTemp[i] = 1;
                    }
                } else {
                    if (states[i - 1] == states[i + 1]) {
                        statesTemp[i] = 0;
                    } else {
                        statesTemp[i] = 1;
                    }
                }
            }
            states = statesTemp;
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
    // METHOD SIGNATURE ENDS

    // Function to return gcd of a and b
    public  static  int gcdHelper(int a, int b)
    {
        if (a == 0)
            return b;
        return gcdHelper(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    public  static int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcdHelper(arr[i], result);

        return result;
    }

    /*public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        int [][] matrix = new int[numRows][numColumns];
        int n = 0;
        int m = 0;
        for(List lotVal:lot) {
            for (int t=0; t<lotVal.size(); t+++) {
                matrix[n][m] = (int)lotVal.get(t);
                m++;
            }
            n++;
            m = 0;
        }

        for(int i=0;i<numRows; i++) {
            for (int j=0;j<numColumns;j++) {
                if (matrix[i][j] == 9) {
                    return i+j;
                }
            }
        }
    } */

    public static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                            List<List<Integer>> allLocations,
                                            int numSteakhouses)
    {
        if(numSteakhouses > totalSteakhouses)
            return new ArrayList<>();


        TreeMap<Double,List<Integer>> distanceMap = new TreeMap<>();
        for (List location: allLocations) {
            double distance = Math.sqrt((Math.pow((Integer)location.get(0),2)  +
                    Math.pow((Integer)location.get(1),2)));
            distanceMap.put(distance,location);
        }


        List<List<Integer>> result = new ArrayList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>(distanceMap.values());
        for (int i=0; i<numSteakhouses; i++) {
              result.add(lists.get(i));
        }
        return result;
    }



    public static void main(String[] args) {


        int [] arr = {1,0,0,0,0,1,0,0};
        int [] arr2 = {1,1,1,0,1,1,1,1};
        //List<Integer> integers = cellCompete(arr2, 2);
        //System.out.println(integers);

        int [] arr3 = {72,60};
        List<List<Integer>> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Integer> a3 = new ArrayList<>();
        ArrayList<Integer> a4 = new ArrayList<>();
        ArrayList<Integer> a5 = new ArrayList<>();
        ArrayList<Integer> a6 = new ArrayList<>();
        a1.add(3);
        a1.add(6);
        a2.add(2);
        a2.add(4);
        a3.add(5);
        a3.add(3);
        a4.add(2);
        a4.add(7);
        a5.add(1);
        a5.add(8);
        a6.add(7);
        a6.add(9);


        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        a.add(a5);
        a.add(a6);
        System.out.println(nearestXsteakHouses(6,a,3));
        //System.out.println(findGCD(arr3,2));
    }
}

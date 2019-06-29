package MySolutions.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    generateHelper(numRows, result);
    return result;
  }

  private static ArrayList<Integer> generateHelper(int numRows, List<List<Integer>> result) {

    if (numRows == 0) {
      return new ArrayList<>();
    }

    ArrayList<Integer> recList = generateHelper(numRows - 1, result);
    ArrayList<Integer> list = new ArrayList<>();

    if (numRows <= 2) {
      recList.add(1);
      list.addAll(recList);
      result.add(new ArrayList<>(recList));
    } else {
      list.add(1);
      for (int i = 0; i < recList.size() - 1; i++) {
        list.add(recList.get(i) + recList.get(i + 1));
      }
      list.add(1);
      result.add(list);
    }

    return list;
  }

  public static void main(String[] args) {
    List<List<Integer>> generate = generate(5);
    generate.stream().forEach(System.out::println);
  }
}

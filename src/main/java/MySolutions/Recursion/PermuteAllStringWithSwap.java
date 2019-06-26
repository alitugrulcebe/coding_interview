package MySolutions.Recursion;

import java.util.ArrayList;

import static MySolutions.GeekforGeeks.string.StringQuestions.swap;

public class PermuteAllStringWithSwap {

  private static int counter = 0;
  public static ArrayList<String> permute(String str, int l, int r,ArrayList<String> result)
  {
    if (l == r) {
      result.add(str);
    }
    else
    {
      for (int i = l; i < r; i++)
      {
        str = swap(str,l,i);
        permute(str, l+1, r,result);
        str = swap(str,l,i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<String> abc = permute("ABC", 0, 3, result);
    System.out.println(result);
  }
}

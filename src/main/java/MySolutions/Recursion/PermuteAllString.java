package MySolutions.Recursion;

import java.util.ArrayList;

import static MySolutions.GeekforGeeks.string.StringQuestions.swap;

public class PermuteAllString {

  private static int counter = 0;
  public static ArrayList<String> permute(String str, int l, int r,ArrayList<String> result)
  {

    //System.out.println("FUNC CALL START ########################### " + str);
    //System.out.println("FUNC CALL Str : " + str + " i : " + l + " R : " + r);
    //System.out.println("FUNC CALL END ########################### " + str);
    if (l == r) {
      //System.out.println("BASE CASE ########################### " + str);
      result.add(str);
    }
    else
    {
      for (int i = l; i < r; i++)
      {
        //System.out.println("BEFORE swap oncesi Str : " + str + " i : " + i + " L : " + l + " R : " + r);
        System.out.println("BEFORE SWAP (" + l + " , " + i + ")");
        str = swap(str,l,i);
        System.out.println("BEFORE STR : " + str);
        //System.out.println("BEFORE swap sonrasi Str : " + str + " i : " + i + " L : " + l + " R : " + r);
        System.out.println("FUNC CALL Str : " + str + " i : " + i + " L :" + (l+1) + " R : " + r);
        permute(str, l+1, r,result);
        //System.out.println("AFTER swap oncesi Str : " + str + " i : " + i + " L : " + l + " R : " + r);
        System.out.println("AFTER SWAP (" + l + " , " + i + ")");
        str = swap(str,l,i);
        System.out.println("AFTER STR : " + str);
        //System.out.println("AFTER swap sonrasi Str : " + str + " i : " + i + " L : " + l + " R : " + r);
      }
    }
    return result;
  }

  public static void permute2(String sofar,String rest) {
      if(rest.isEmpty()) {
        counter++;
        System.out.println(sofar);
      } else {
        for (int i=0;i<rest.length();i++) {
          String remaining = rest.substring(0,i) + rest.substring(i+1);
          permute2(sofar + rest.toCharArray()[i],remaining);
        }
      }
  }

  // All possibilities
  public static void permute3(String sofar,String rest) {
    if(rest.isEmpty()) {
      //System.out.println("BASE SOFAR : " + sofar + " REST : " + rest);
      System.out.println(sofar);
    } else {
      //System.out.println("Oncesi SOFAR : " + sofar + " REST : " + rest);
      permute3(sofar + rest.substring(0,1),rest.substring(1));
      //System.out.println("SONRASI SOFAR : " + sofar + " REST : " + rest);
      permute3(sofar,rest.substring(1));
    }
  }



  public static void main(String[] args) {
    ArrayList<String> result = new ArrayList<>();
    System.out.println("PERMUTE 1 ######################");
    ArrayList<String> abc = permute("ABC", 0, 3, result);
    //System.out.println("Toplam :" + result.size());
    System.out.println("PERMUTE 2 ######################");
    permute2("","ABC");
    System.out.println("Toplam :" + counter);

    System.out.println("PERMUTE 3 ######################");
    permute3("","ABC");
  }
}

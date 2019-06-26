package MySolutions.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessString {


  public static int process(String s) {
    String s1 = new String("123");
    s1 = s1.intern();
    String s3 = "123";
    String s2 = new String("123");
    System.out.println(s1 == s3);

    int multiplier = 1;
    List<Integer> list = new ArrayList<>();
    String r = "";
    for(int i=0;i<s.length();i++) {
      if(s.charAt(i) == '-')
        multiplier = -1;

      if(Character.isDigit(s.charAt(i))) {
        r += s.charAt(i);
      } else {
        if(!r.isEmpty()) {
          list.add(multiplier * Integer.parseInt(r));  // 123
          r = "";
          multiplier = 1;
        }
      }
    }
    int result = 0;
    for(Integer v:list) {
      result += v;
    }

    return result;
  }

  public static void main(String[] args) {
    //process("123ab!45c");
    process("12a-10b");
  }
}

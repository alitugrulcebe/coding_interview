package MySolutions.LeetCodeWalmart;

public class Questions2 {
//  Create all permutations of a string
//
//  input :: abc
//  output :: abc, acb , bca, bac, cba , cab

  public static void permute(String s,String soFar,int index) {
    if(index == s.length())
      System.out.println(soFar);


    for(int i=0;i<s.length();i++) {
      soFar += s.charAt(i);
      permute(s,soFar,index+1);
    }
  }

//  Given an Array, Separate even and odd numbers. Do not change order of elements and do not use other array
//  Input : 1, 2, 4, 7, 5, 8, 10
//  Output : 1, 7, 5, 2, 4, 8, 10

  public static int[] seperateEvenOddNumbers(int[] arr) {

    int f = 0;
    int l = arr.length-1;
    while(f < l) {
      if(arr[f]%2 == 0 && arr[l]%2 == 1) {
        int tmp = arr[f];
        arr[f] = arr[l];
        arr[l] = tmp;
      }
      f++;
      l--;
    }
    return arr;
  }

  public static void main(String[] args) {
      //permute("abc","",0);
    int[] ints = seperateEvenOddNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    for (int i:ints)
      System.out.print(i + " ");
  }
}

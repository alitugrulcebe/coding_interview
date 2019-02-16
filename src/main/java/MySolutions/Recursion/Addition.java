package MySolutions.Recursion;

public class Addition {
    public static int add(int a, int b)
    {
        if(b == 0)
            return a;
        else
        if(b < 0)
            return add(a -1,b + 1);
        else
            return add(a + 1,b - 1);
    } // add

    public static void main(String[] args) {
        System.out.println(add(2,3));
    }
}

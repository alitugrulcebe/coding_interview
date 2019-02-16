package MySolutions.Recursion;

public class Subtraction {
    public static int sub(int a, int b)
    {
        if(b == 0)
            return a;
        else
        if(b < 0)
            return sub(a + 1,b + 1);
        else
            return sub(a -1,b -1);
    } // sub

    public static void main(String[] args) {
        System.out.println(sub(5,2));
    }
}

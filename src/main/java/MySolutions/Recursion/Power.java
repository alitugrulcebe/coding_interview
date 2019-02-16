package MySolutions.Recursion;

public class Power {

    public static int power(int x, int y)
    {
        if (y == 0)
            return 1;
        else
            return x*power(x, y-1);
    } // power

    public static void main(String[] args) {
        System.out.println(power(3,3));
    }
}

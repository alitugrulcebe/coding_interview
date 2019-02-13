package MySolutions.Recursion;

public class GCD {
    /*
    a = g*x     b = g*y
    Note that we can express a in terms of b.  By dividing a by b, we will obtain the quotient
    q = floor(a/b)
    r = a%b
    a = q * b + r

    r = g * ( x- (q * y) )


     */
    // Recursive
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }



    // Non-recursive
    static int gcdIterative(int a, int b)
    {
        if (a < b)
            swap(a, b);

        while (b > 0)
        {
            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }

    private static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = a;
    }

    public static void main(String[] args) {
        System.out.println(gcdIterative(125,35));
    }

}

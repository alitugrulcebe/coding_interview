package MySolutions.Recursion;

public class PowImplementation {
    public static double myPow(double x, int n) {
        double pow = x;
        if(n > 0) {
            for(int i=1;i<n;i++)
                x = x*pow;
        } else {
            for(int i=0;i<Math.abs(n);i++)
                x = 1/(x * pow);
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0,10));
    }
}

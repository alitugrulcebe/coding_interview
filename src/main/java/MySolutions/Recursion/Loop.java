package MySolutions.Recursion;

public class Loop {
    public static int recLoop(int num)
    {
        if(num == 1)
            return 1;
        int sum = num;
        for(int i = 1; i < num; i++)
            sum = sum + recLoop(i);
        return sum;
    } // recLoop

    public static void main(String[] args) {
        System.out.println(recLoop(4));
    }
}

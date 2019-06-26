package MySolutions.Interview;

public class Abstract1Extend extends Abstract implements Deneme {

    public Abstract1Extend() {
        super();

    }

    public void method4(int param1, int param2) {

    }

    @Override
    public void method2() {
        System.out.println("Deneme");
    }

    @Override
    public void method3() {

    }

    public static void main(String[] args) {
        Deneme a = new Abstract1Extend();
        Deneme.method4(1,2);
        a.method1();
    }


}

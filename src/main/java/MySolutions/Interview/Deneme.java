package MySolutions.Interview;

public interface Deneme {

    public static void method4(int param1,int param2) {
        System.out.println(param1 + " " + param2);
    }

    default void method1() {
        System.out.println("Interface is called");
    }

    default void method2() {

    }

    void method3();
}

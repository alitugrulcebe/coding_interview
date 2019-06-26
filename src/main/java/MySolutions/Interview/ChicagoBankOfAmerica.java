package MySolutions.Interview;


public class ChicagoBankOfAmerica {
    public static class A {
        public int getNumber() {
            return 2;
        }
    }

    public static class B extends A {
        public int getNumber() {
            return 1;
        }
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.getNumber());
        B b = new B();
        A x = (A) b;
        System.out.println(x.getNumber());
    }

}

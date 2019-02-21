package MySolutions.Recursion;

public class PermuteAllPossibleStrings {

    // All possibilities
    public static void permute(String sofar,String rest) {
        if(rest.isEmpty()) {
            System.out.println(sofar);
        } else {
            permute(sofar + rest.substring(0,1),rest.substring(1));
            permute(sofar,rest.substring(1));
        }
    }

    public static void main(String[] args) {
        permute("","ABC");
    }
}

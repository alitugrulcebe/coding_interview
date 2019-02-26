package MySolutions.Recursion;

public class PermuteStringsWithRemaining {
    public static void permute(String sofar,String rest,String indent) {
        System.out.println(indent + "Permute Sofar: " + sofar + " Rest :" + rest);
        if(rest.isEmpty()) {
            System.out.println(sofar);
        } else {
            for (int i=0;i<rest.length();i++) {
                String remaining = rest.substring(0,i) + rest.substring(i+1);
                permute(sofar + rest.toCharArray()[i],remaining,indent+indent);
            }
        }
    }

    public static void main(String[] args) {
        permute("","ABC"," ");
    }
}

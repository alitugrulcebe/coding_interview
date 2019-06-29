package MySolutions.Recursion;

public class PermuteStringsWithRemaining {
    public static void permute(String sofar,String rest,String indent) {
        System.out.println(indent + "Permute Sofar: " + sofar + " Rest :" + rest);
        if(rest.isEmpty()) {
            System.out.println(sofar);
        } else {
            for (int i=0;i<rest.length();i++) {
                String newRest = rest.substring(0,i) + rest.substring(i+1);
                System.out.println(indent + "newRest : " + newRest + " Rest :" + rest);
                permute(sofar + rest.charAt(i),newRest,indent+indent);
            }
        }
    }

    public static void main(String[] args) {
        permute("","ABC"," ");
    }
}

package MySolutions.Recursion;

public class GenerateBinaryRepresentation {

    public static void generateBinaryRep(int[] num,int index,int n) {
        if(index >= n) {
            for(int i=0;i<num.length;i++)
                System.out.print(num[i]);
            System.out.println();
            return;
        }

        for(int i=0;i<2;i++) {
            num[index] = i;
            generateBinaryRep(num,index+1,n);
        }
    }

    public static void main(String[] args) {
        generateBinaryRep(new int[4],0,4);
    }
}

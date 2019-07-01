package MySolutions.EPI.array;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;



public class EvenOdd {

    public static String fromHex(String s)throws UnsupportedEncodingException {
        byte bs[]=new byte[s.length()/2];
        for(int i=0;i<s.length();i+=2){
            bs[i/2]=(byte)Integer.parseInt(s.substring(i,i+2),8);
        }
        return new String(bs,"UTF8");
    }

    public static void evenOdd(int[] A) {
        int nextEven = 0, nextOdd = A.length - 1;
        while (nextEven < nextOdd) {
            if (A[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                int tmp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = tmp;
            }
        }
    }

}

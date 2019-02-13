package MySolutions.GeekforGeeks.string;

import java.util.Arrays;

public class StringQuestions {

    String reversingString(String str, int start, int end)
    {
        // Iterate loop upto start not equal to end
        while (start < end)
        {
            // XOR for swapping the variable
            str.toCharArray()[start] ^= str.toCharArray()[end];
            str.toCharArray()[end] ^= str.toCharArray()[start];
            str.toCharArray()[start] ^= str.toCharArray()[end];

            ++start;
            --end;
        }
        return str;
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i < r; i++)
            {
                System.out.println("###################BEFORE_REC_BEGIN###############################");
                System.out.println(i+ " level");
                System.out.println("Before Swap MySolutions.String is " + str + " Swap olacaklar " + str.toCharArray()[l] + " , "
                        + str.toCharArray()[i]);

                str = swap(str,l,i);

                System.out.println("Swap " + str.toCharArray()[l] + " , "
                        + str.toCharArray()[i]);
                System.out.println("After swap MySolutions.String is " + str);
                System.out.println("###################BEFORE_REC_END###############################");

                permute(str, l+1, r);

                System.out.println("###################AFTER_REC_BEGIN###############################");
                System.out.println("After Rec Before Swap MySolutions.String is " + str + " Swap olacaklar " + str.toCharArray()[l] + " , "
                        + str.toCharArray()[i]);

                str = swap(str,l,i);

                System.out.println("Swap " + str.toCharArray()[l] + " , "
                        + str.toCharArray()[i]);
                System.out.println("After swap MySolutions.String is " + str);
                System.out.println("###################AFTER_REC_END###############################");
            }
        }
    }

    // Function that matches input str with
    // given wildcard pattern
    static boolean strmatch(String str, String pattern,
                            int n, int m)
    {
        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initailze lookup table to false
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);


        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }

        return lookup[n][m];
    }

    public static void main(String[] args) {
        permute("ABCD",0,4);

        String str = "baaabab";
        String pattern = "*****ba*****ab";
        // MySolutions.String pattern = "ba*****ab";
        // MySolutions.String pattern = "ba*ab";
        // MySolutions.String pattern = "a*ab";
        // MySolutions.String pattern = "a*****ab";
        // MySolutions.String pattern = "*a*****ab";
        // MySolutions.String pattern = "ba*ab****";
        // MySolutions.String pattern = "****";
        // MySolutions.String pattern = "*";
        // MySolutions.String pattern = "aa?ab";
        // MySolutions.String pattern = "b*b";
        // MySolutions.String pattern = "a*a";
        // MySolutions.String pattern = "baaabab";
        // MySolutions.String pattern = "?baaabab";
        // MySolutions.String pattern = "*baaaba*";

        if (strmatch(str, pattern, str.length(),
                pattern.length()))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

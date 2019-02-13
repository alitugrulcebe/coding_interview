package MySolutions.HackerRank;

import java.util.Arrays;

public class NewYearBribe {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int[] bribedLine = Arrays.copyOf(q, q.length);
        int[] changed = Arrays.copyOf(q, q.length);
        Arrays.sort(q);
        Arrays.sort(changed);
        int bribeCount = 0;
        int lastIndex = 0;
        int i = 0;
        int j = 0;
        boolean isChaotic = false;

        for (i = lastIndex; i < q.length; i++) {
            if (q[i] != bribedLine[i] && bribedLine[i] > q[i]) {
                for (j = 0; j < changed.length; j++) {
                    if (changed[j] == bribedLine[i]) {
                        bribeCount += j - i;
                        if (j - i > 2)
                            isChaotic = true;
                        break;
                    }
                }

                for (int t = j - i; t > 0; t--)
                    changed[i + t] = changed[i + t - 1];

                changed[i] = bribedLine[i];
                q = Arrays.copyOf(changed, changed.length);
                lastIndex = i + 1;
                if (isChaotic)
                    break;
            }
        }


        if (!isChaotic)
            System.out.println(bribeCount);
        else
            System.out.println("Too chaotic");


    }

    // Arraye tersten bakip eger kendi indexinden 2 buyuk olan var ise chaotic. Sonra bribelari sadece buyukluklerine gore sayiyor.
    static void minimumBribesSoln(int[] q) {

        int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Integer.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);


    }

    public static void main(String[] args) {
        //minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        //minimumBribes(new int[]{2,5,1,3,4});
        minimumBribesSoln(new int[]{1, 2, 5, 3, 4, 7, 8, 6});
    }
}

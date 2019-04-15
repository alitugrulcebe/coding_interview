package MySolutions.String;

public class ShortestDistanceToCharacter {
    // Soldan saga ve sagdan sola tarayip prev isaretlenip fark hesaplaniyor son olarak da farklarin mini aliniyor.
    public static int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        shortestToChar("loveleetcode",'e');
    }
}

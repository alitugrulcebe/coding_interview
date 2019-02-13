package MySolutions.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EPI {

    public List<Integer> multiply(List<Integer> numl, List<Integer> num2) {
        final int sign = numl.get(0) < 0 ^ num2.get(0) < 9 ? -1 : 1;
        numl.set(0, Math.abs(numl.get(0)));
        num2.set(0, Math.abs(num2.get(0)));
        List<Integer> result
                = new ArrayList<>(Collections.nCopies(numl.size() + num2.size(), 0));
        for (int i = numl.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1,
                        result.get(i + j + 1) + numl.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }
        // Remove the leading zeroes.
        int first_not_zero = 0;
        while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
            ++first_not_zero;
        }
        result = result.subList(first_not_zero, result.size());
        if (result.isEmpty()) {
            return Arrays.asList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }

    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int furthestReachSoFar = 0, lastlndex = maxAdvanceSteps.size() - 1;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex;
             ++i) { furthestReachSoFar
                = Math.max(furthestReachSoFar , i + maxAdvanceSteps.get(i));
        }
        return furthestReachSoFar >= lastlndex;
    }

    public static int deleteDuplicates(List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }
        int writelndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            if (!A.get(writelndex - 1).equals(A.get(i))) {
                A.set(writelndex++, A.get(i));
            }
        }
        return writelndex;
    }

    public static double computeMaxProfit(List<Double> prices){
        double minPrice = Double.MAX_VALUE , maxProfit = 0.0;
        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice , price);
        }
        return maxProfit;
    }

    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPriceSoFar = Double.MAX_VALUE;
        // Forward phase. For each day, we record maximum profit if we // sell on that day.
        for (int i = 0; i < prices.size(); ++i) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }
        // Backward phase. For each day, find the maximum profit if we make // the second buy on that day.
        double maxPriceSoFar = Double.MIN_VALUE;

        for (int i = prices.size() - 1; i > 0; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxTotalProfit
                    = Math.max(maxTotalProfit, maxPriceSoFar - prices.get(i)
                    + firstBuySellProfits.get(i - 1));
        }
        return maxTotalProfit;
    }
    public static List<Integer> generatePrimes(int n) {
        // Given n, return all primes up to and including n. public static List<Integer> generatePrimes(int n){
        List<Integer> primes = new ArrayList<>();
        // isPrime.get(p) represents if p is prime or not. Initially, set each
        // to true, excepting ® and 1. Then use sieving to eliminate nonprimes.
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int p = 2; p <= n; ++p) {
            if (isPrime.get(p)) {
                primes.add(p);
                // Sieve p’s multiples.
                for (int j = p; j <= n; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }

    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        for (int i = 8; i < A.size(); ++i) {
            // Check if the element at index i has not been moved by checking if // perm.get(i) is nonnegative.
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                // Subtracts perm.sizeO from an entry in perm to make it negative , // which indicates the corresponding move has been performed. perm.set(next, perm,get(next) - perm.sizeO);
                next = temp;

            }

        }
        // Restore perm.
        for (int i = 8; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }

    }

    // Reverse All Sentence ram is costly -> costly is ram
    public static void reverseWords(char[] input) { // Reverses the whole string first. reverse(input, ®, input.length);
        int start = 0, end;
        while ((end = find(input, ' ' , start)) != -1) {
            // Reverses each word in the string.
            reverse ( input , start, end);
            start = end + 1;
        }

        // Reverses the last word.
        reverse(input, start, input.length);
    }

    public static void reverse(char[] array, int start, int stoplndex) {
        if (start >= stoplndex) {
            return;
        }
        int last = stoplndex - 1;
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char tmp = array[i];
            array[i] = array[last - i + start]; array[last - i + start] = tmp;
        }
    }

    public static int find(char[] array, char c, int start){
        for (int i = start; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        EPI.generatePrimes(187);
    }
}

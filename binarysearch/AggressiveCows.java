package binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    public static boolean can_put(int stalls[], int cows, int min) {
        int i = 1, prevIdx = 0;
        cows--;
        while (i < stalls.length && cows > 0) {
            if (stalls[i] - stalls[prevIdx] >= min) {
                prevIdx = i;
                cows--;
            }
            i++;
        }
        return cows == 0;
    }

    public static int acows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int max = Integer.MIN_VALUE;
        for (int stall : stalls) {
            if (stall > max)
                max = stall;
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int ans = left + (right - left) / 2;
            if (can_put(stalls, cows, ans)) {
                left = ans + 1;
            } else {
                right = ans - 1;
            }
        }

        return right;

    }

    public static void main(String[] args) {
        int stalls[] = { 0, 3, 4, 7, 9, 10 };
        System.out.println(acows(stalls, 7));
    }
}

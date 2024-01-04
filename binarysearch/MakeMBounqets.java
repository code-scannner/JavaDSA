package binarysearch;

public class MakeMBounqets {

    // make m bouquets where each bounquet should contain k consecutive flowers
    // whose bloom days are given

    public static boolean bloom_possible(int bloomdays[], int m, int k, int day) {
        int i = 0, flowers = 0;
        while (m > 0 && i < bloomdays.length) {
            // flower is bloomed
            if (bloomdays[i] <= day) {
                flowers++;
            } else {
                flowers = 0;
            }
            if (flowers == k) {
                m--;
                flowers = 0;
            }
            i++;
        }
        return m == 0;
    }

    public static int minDays(int bloomdays[], int m, int k) {
        if (bloomdays.length < m * k)
            return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int bloomday : bloomdays) {
            if (bloomday > max)
                max = bloomday;
            if (bloomday < min)
                min = bloomday;
        }

        int left = min;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (bloom_possible(bloomdays, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public static void main(String[] args) {
        int bloomday[] = { 7, 7, 7, 7, 13, 11, 12, 7 };
        System.out.println(minDays(bloomday, 2, 3));
        System.out.println(minDays(bloomday, 2, 5));
    }
}

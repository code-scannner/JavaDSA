package binarysearch;

import java.util.*;

public class MinimizeMaxDisGasStation {
    public static int gas_stations(int stations[], double maxDist) {
        int total = 0;
        for (int i = 1; i < stations.length; i++) {
            int diff = stations[i] - stations[i - 1];
            if (diff % maxDist == 0) {
                total += diff / maxDist - 1;
            } else
                total += diff / maxDist;
        }

        return total;
    }

    public static double minimizeDis(int stations[], int k) {
        Arrays.sort(stations);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int station : stations) {
            if (station > max)
                max = station;
            if (station < min)
                min = station;
        }

        double left = 0;
        double right = (double) (max - min);
        double prev = left;

        while (left <= right) {
            double mid = (left + (right - left) / 2);
            mid = (int) (mid * 10000000d) / 10000000d;
            if (mid == prev)
                break;

            int ans = gas_stations(stations, mid);

            if (ans > k) {
                left = mid + 0.0000001;
            } else {
                right = mid - 0.0000001;
            }

            prev = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println(minimizeDis(arr, 1));

    }
}

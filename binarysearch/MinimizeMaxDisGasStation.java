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

        double left = 0;
        double right = (double) (stations[stations.length - 1] - stations[0]);

        double diff = (int) 1e-6;
        while (right - left > diff) {
            double mid = (left + (right - left) / 2.0);

            int ans = gas_stations(stations, mid);

            if (ans > k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(minimizeDis(arr, 4));

    }
}

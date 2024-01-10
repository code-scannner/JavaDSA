package gfg;

import java.util.*;

public class LongSubarrWthSumDivByK {

    public static int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Complete the function

        int map[] = new int[k];
        Arrays.fill(map, -2);

        long sum = 0L;
        int length = 0;
        map[0] = -1;

        for (int i = 0; i < n; i++) {
            int num = a[i];
            sum += num;
            int rem = (int) (Math.abs(sum) % k);
            if (sum < 0) {
                rem = (k - rem) % k;
            }
            if (map[rem] == -2) {
                map[rem] = i;
            }
            length = Math.max(length, i - map[rem]);
        }

        return length;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 6, 1, 4, 5 };
        // int arr[] = { -1, 9, 0 };
        // 2,9,15,16,20,25
        System.out.println(longSubarrWthSumDivByK(arr, arr.length, 9));
    }

}
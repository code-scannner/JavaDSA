package leetcode;

import java.util.*;

// TODO : Optimize it
public class leet_1296 {
    public static boolean isPossibleDivide(int[] arr, int k) {
        int n = arr.length;
        if (n % k != 0)
            return false;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int len = k, item = arr[i];
                for (int j = i; len > 0 && j < n; j++) {
                    if (arr[j] != 0) {
                        if (arr[j] - item > k - len) {
                            return false;
                        }
                        if (arr[j] - item == k - len) {
                            len--;
                            arr[j] = 0;
                        }
                    }
                }
                if (len > 0)
                    return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11,5,7,6
        };
        System.out.println(isPossibleDivide(arr, 3));
    }
}

package maths;

import java.util.*;

public class MissingRepeating {
    public static int[] usingMaths(int arr[]) {
        int n = arr.length;
        long sum = 0;
        long sq = 0;
        for (int num : arr) {
            sum += num;
            sq += num * num;
        }
        long asum = n * (n + 1) / 2;
        long asq = n * (n + 1) * (2 * n + 1) / 6;

        int sumdiff = (int) (asum - sum);
        int sqdiff = (int) (asq - sq);

        // x = missing number, y = repeating number
        int x = (sumdiff + (sqdiff / sumdiff)) / 2;

        return new int[] { x, x - sumdiff };

    }

    public static int[] usingXOR(int arr[]) {
        int xor = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            xor ^= (arr[i] ^ (i + 1));
        }

        // finding a differentiating bit 
        // to separate x and y into two groups
        int diffbit = 0;
        while (xor != 0 && (xor & 1) == 0) {
            diffbit++;
            xor >>= 1;
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            if ((((i + 1) >> diffbit) & 1) == 1)
                x ^= (i + 1);
            else
                y ^= (i + 1);
            if (((arr[i] >> diffbit) & 1) == 1)
                x ^= arr[i];
            else
                y ^= arr[i];
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                cnt++;
        }

        return cnt == 0 ? new int[] { x, y } : new int[] { y, x };
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 5, 6, 2, 1, 1 };

        // arr[0] = missing no., arr[1] = repeating no.
        // System.out.println(Arrays.toString(usingMaths(arr)));
        System.out.println(Arrays.toString(usingXOR(arr)));
    }
}

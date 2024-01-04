package binarysearch;

import java.util.Arrays;

public class SmallestDivisor {
    public static int dividedSum(int numbers[], int divisor) {
        int sum = 0;
        for (int num : numbers) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

    public static int smallestDivisor(int numbers[], int threshold) {

        if(threshold < numbers.length) return -1;

        int left = 1;
        int right = Arrays.stream(numbers).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int dsum = dividedSum(numbers, mid);
            if (dsum > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, 9 };
        // divisor = 1 , dsum = 1 + 2 + 5 + 9 = 17;
        // divisor = 2 , dsum = 1 + 1 + 3 + 5 = 10;
        // divisor = 3 , dsum = 1 + 1 + 2 + 3 = 7;
        // divisor = 4, dsum = 1 + 1 + 2 + 3 = 7;
        // divisor = 5, dsum = 1 + 1 + 1 + 2 = 5;
        System.out.println(smallestDivisor(arr, 5));
        System.out.println(smallestDivisor(arr, 7));
        System.out.println(smallestDivisor(arr, 70));
        System.out.println(smallestDivisor(arr, 3));

    }
}

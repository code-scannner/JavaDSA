package bitmanipulation;

import java.util.*;

public class Operations {
    public static void main(String[] args) {
        System.out.println(reverseBits(6));
        System.out.println(complementBits(8));
        System.out.println(countBits(31));
        int arr[] = { 123, 456 };
        swap(arr, 1, 0);
        System.out.println(Arrays.toString(arr));
        System.out.println(checkIthBit(13, 1));
        System.out.println(setIthBit(13, 1));
        System.out.println(invertIthBit(15, 0));
        System.out.println(clearIthBit(15, 1));
        System.out.println(removeLastBit(13));
    }

    public static int removeLastBit(int n) {
        return n & (n - 1);
    }

    public static int invertIthBit(int num, int i) {
        return (num ^ (1 << i));
    }

    public static int clearIthBit(int num, int i) {
        return num & ~(1 << i);
    }

    public static int setIthBit(int num, int i) {
        return (num | (1 << i));
    }

    public static int checkIthBit(int num, int i) {
        return (num & (1 << i)) == 0 ? 0 : 1;
    }

    public static int xorOfN(int n) {
        if (n % 4 == 0)
            return n;
        if (n % 3 == 0)
            return 0;
        if (n % 2 == 0)
            return n + 1;
        else
            return 1;
    }

    public static void swap(int arr[], int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static int countBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >> 1;
        }
        return count;
    }

    // n is positive
    public static int reverseBits(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed <<= 1;
            reversed |= (n & 1);
            n >>= 1;
        }

        return reversed;
    }

    public static int complementBits(int n) {
        int complemented = 0;
        int i = 0;
        while (n != 0) {
            complemented |= (1 - (n & 1)) << i;
            i++;
            n >>= 1;
        }
        return complemented;
    }

}

package stack;

import java.util.*;

import arrays.NextPermutation;

public class NextGreater {
    public static int[] findNextGreater(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }
            result[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(arr[i]);
        }

        return result;
    }

    public static int[] findCircularNextGreater(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i % arr.length]) {
                stk.pop();
            }
            result[i % arr.length] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(arr[i % arr.length]);
        }

        return result;
    }

    // find the smallest integer which has exactly the same digits
    // existing in the integer n and is greater in value than n
    public static int nextGreaterIII(int n) {
        String str = String.valueOf(n);
        String arr[] = str.split("");
        int digits[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            digits[i] = arr[i].charAt(0) - '0';
        }
        NextPermutation.next_permutation(digits);
        long nextNum = 0;
        for (int digi : digits) {
            nextNum = nextNum * 10 + digi;
        }
        System.out.println(nextNum);
        if (nextNum > Math.pow(2, 31) - 1 || nextNum <= n)
            return -1;
        else
            return (int) nextNum;

    }

    public static void main(String[] args) {

        int arr[] = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
        System.out.println(Arrays.toString(findNextGreater(arr)));
        System.out.println(Arrays.toString(findCircularNextGreater(arr)));
        System.out.println(nextGreaterIII(21));
    }
}

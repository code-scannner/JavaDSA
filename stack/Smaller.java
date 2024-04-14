package stack;

import java.util.*;

public class Smaller {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(Arrays.toString(nextSmallerIndex(arr)));
        System.out.println(Arrays.toString(nextSmaller(arr)));
        System.out.println(Arrays.toString(prevSmallerIndex(arr)));
        System.out.println(Arrays.toString(prevSmaller(arr)));
    }

    public static int[] prevSmaller(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && stk.peek() > arr[i])
                stk.pop();
            result[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(arr[i]);
        }
        return result;
    }

    public static int[] prevSmallerIndex(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[] { -1, Integer.MIN_VALUE });
        for (int i = 0; i < n; i++) {
            while (stk.peek()[1] > arr[i])
                stk.pop();
            result[i] = stk.peek()[0];
            stk.push(new int[] { i, arr[i] });
        }
        return result;
    }

    public static int[] nextSmaller(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() > arr[i])
                stk.pop();
            result[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(arr[i]);
        }
        return result;
    }

    public static int[] nextSmallerIndex(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[] { n, Integer.MIN_VALUE });
        for (int i = n - 1; i >= 0; i--) {
            while (stk.peek()[1] > arr[i])
                stk.pop();
            result[i] = stk.peek()[0];
            stk.push(new int[] { i, arr[i] });
        }
        return result;
    }
}

package stack;
import java.util.*;

public class LargestRectangle {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        // int arr[] = { 2, 4 };
        System.out.println(maxAreaInHistogram(arr));
        System.out.println(maxAreaInHistogramOptimized(arr));
    }

    public static int maxAreaInHistogramOptimized(int arr[]) {
        int n = arr.length, max = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<=n; i++){
            while (!stk.isEmpty() && (i == n || arr[i] < arr[stk.peek()])) {
                int currIdx = stk.pop();
                int next = i;
                int prev = stk.isEmpty() ? -1: stk.peek();
                int area = arr[currIdx] * (next - prev - 1);
                max = Math.max(max, area);

            }
            stk.push(i);
        }
        return max;
    }
    public static int maxAreaInHistogram(int arr[]) {
        int prevSmall[] = Smaller.prevSmallerIndex(arr);
        int nextSmall[] = Smaller.nextSmallerIndex(arr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (nextSmall[i] - prevSmall[i] - 1));
        }
        return max;
    }

}

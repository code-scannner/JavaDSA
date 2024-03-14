package slidingwindow;

import java.util.*;

// return the array of max in each window of size k 

class Pair {
    int ind;
    int num;

    Pair(int _num, int _ind) {
        ind = _ind;
        num = _num;
    }
}

public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;

        int n = nums.length;
        int result[] = new int[n - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.num - a.num);

        for (int i = 0; i < k - 1; i++) {
            pq.offer(new Pair(nums[i], i));
        }

        for(int i = k - 1; i<n; i++){
            pq.offer(new Pair(nums[i], i));
            while(pq.peek().ind <= i - k){
                pq.remove();
            }
            result[i - k + 1] = pq.peek().num;
        }

        return result;
    }

    public static int[] maxSlidingWindowDequeue(int[] nums, int k) {
        if (k == 1)
            return nums;

        int n = nums.length;
        int result[] = new int[n - k + 1];
        
        Deque<Pair> dq = new LinkedList<>();
        
        for (int i = 0; i < k - 1; i++) {
            while(!dq.isEmpty() && dq.getLast().num <= nums[i]){
                dq.removeLast();
            }
            dq.offerLast(new Pair(nums[i], i));
        }
        
        for(int i = k - 1; i<n; i++){
            while(!dq.isEmpty() && dq.getLast().num <= nums[i]){
                dq.removeLast();
            }
            dq.offerLast(new Pair(nums[i], i));

            while(dq.getFirst().ind <= i - k){
                dq.removeFirst();
            }
            result[i - k + 1] = dq.getFirst().num;
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
        System.out.println(Arrays.toString(maxSlidingWindowDequeue(arr, 3)));

    }
}

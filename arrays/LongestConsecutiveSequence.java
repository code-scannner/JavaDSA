package arrays;
import java.util.*;

public class LongestConsecutiveSequence {
    public static int longest_sequence(int arr[]) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr) set.add(num);
        int max = 0;
        for(Integer num : set){
            if(!set.contains(num - 1)){
                int c = 1;
                num++;
                while(set.contains(num)){
                     num++;
                     c++;
                }
                max = Math.max(max, c);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr [] = {100,4, 101,102,200,1,3,2};
        System.out.println(longest_sequence(arr));
    }
}

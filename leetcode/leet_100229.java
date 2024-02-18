package leetcode;
import java.util.*;

public class leet_100229 {
    public static int countDigits(int num){
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num/=10;
        }
        return cnt;
    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr1){
            while(num != 0){
                set.add(num);
                num/=10;
            }
        }   
        int max = 0;
        for(int num : arr2){
            while(num != 0){
                if(set.contains(num)){
                    max = Math.max(max, countDigits(num));
                }
                num/=10;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr1[] = {1,10,100};
        int arr2[] = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
}

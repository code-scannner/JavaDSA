package arrays;
import java.util.*;

// check whether two indexes present such that there sum is equal to target

public class TwoSum {
    public static boolean usingSort(int []arr, int target){
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = n - 1;
        while(i < j){
            int value = arr[i] + arr[j];
            if(value == target) return true;
            else if(value > target) j--;
            else i++;
        }
        return false;
    }
    public static int[] usingHash(int [] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            int num = arr[i];
            if(map.containsKey(target - num)) return new int[]{map.get(target- num), i};
            map.put(num, i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int arr[] = {2,6,5,8,11};
        int target = 14;
        // System.out.println(usingSort(arr, target));
        System.out.println(Arrays.toString(usingHash(arr, target)));
    }
}

package leetcode;

import java.util.*;

public class leet_2150 {
    public static List<Integer> findLonely(int arr[]) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : arr) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        for (int elem : arr) {
            if (map.get(elem) == 1 && !map.containsKey(elem + 1) && !map.containsKey(elem - 1)) {
                result.add(elem);
            }
        }

        return result;
    }
    public static List<Integer> method2(int arr[]) {
        List<Integer> result = new ArrayList<>();

        if(arr.length == 0) return result;
        if(arr.length == 1){
            result.add(arr[0]);
            return result;
        }

        Arrays.sort(arr);


        if(arr[1] - arr[0] > 1) result.add(arr[0]);

        for (int i = 1; i<arr.length - 1; i++) {
            if(arr[i] - arr[i - 1] > 1 && arr[i + 1] - arr[i] > 1) result.add(arr[i]);
        }

        if(arr[arr.length - 1] - arr[arr.length - 2] > 1) result.add(arr[arr.length - 1]);

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 3 };
        // int nums [] = {10,6,5,8};
        System.out.println(findLonely(nums));
    }
}

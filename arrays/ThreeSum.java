package arrays;

import java.util.*;

public class ThreeSum {

    // time complexity = n^2 + logn( for set data structure) O(n^2);
    public static List<List<Integer>> usingSet(int arr[]) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                if (set.contains(-(arr[i] + arr[j]))) {
                    List<Integer> found = Arrays.asList(arr[i], arr[j], -arr[i] - arr[j]);
                    found.sort(null);
                    ans.add(found);
                }
                set.add(arr[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> l : ans)
            result.add(l);

        return result;
    }

    // time complexity = nlogn + n^2 = O(n^2)
    public static List<List<Integer>> usingTwoPointer(int arr[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {

            int j = i + 1, k = n - 1;
            int remsum = target - arr[i];
            // applying two sum with remsum;
            while (j < k) {

                int sum = arr[j] + arr[k];

                if (sum == remsum) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));

                    // moving j forward till k
                    while (j < k && arr[j + 1] == arr[j])
                        j++;

                    // moving k backward till j
                    while (k > j && arr[k - 1] == arr[k])
                        k--;

                    j++;
                    k--;

                } else if (sum > remsum)
                    k--;
                else
                    j++;
            }

            while (i < n - 2 && arr[i + 1] == arr[i])
                i++;

        }
        return result;
    }

    public static void main(String[] args) {
        // int arr[] = { 0, 2, 2, -1, 0, -2, 2, -2, 0, -1, -2, -1, 2 };
        int arr[] = { -1, 0, 1, 2, -1, -4 };

        // System.out.println(usingTwoPointer(arr, 1));
        System.out.println(usingSet(arr));

    }
}

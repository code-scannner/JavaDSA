package recursion;

import java.util.*;

public class Subsets {
    public static void solve(int arr[], int i, List<Integer> list, int sum) {
        if (i == arr.length) {
            list.add(sum);
            return;
        }

        solve(arr, i + 1, list, sum + arr[i]);
        solve(arr, i + 1, list, sum);
    }

    public static List<Integer> subsets(int arr[]) {
        List<Integer> list = new ArrayList<>();
        solve(arr, 0, list, 0);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { -3,0,3 };
        System.out.println(subsets(arr));
    }
}

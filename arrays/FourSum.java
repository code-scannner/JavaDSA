package arrays;

import java.util.*;

public class FourSum {

    public static List<List<Integer>> usingPointer(int arr[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int remsum = target - arr[i] - arr[j];
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = arr[k] + arr[l];
                    if (sum == remsum) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        while (k < l && arr[k] == arr[k + 1])
                            k++;
                        while (l > k && arr[l] == arr[l - 1])
                            l--;
                        k++;
                        l--;
                    } else if (sum < remsum)
                        k++;
                    else
                        l--;
                }

                while (j < n - 2 && arr[j + 1] == arr[j])
                    j++;
            }

            while (i < n - 3 && arr[i + 1] == arr[i])
                i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, -1, 0, -2, 2 };

        System.out.println(usingPointer(arr, 0));

    }
}

package arrays;

import java.util.*;

public class MooreVoting {
    public static int count(int arr[], int elem) {
        int cnt = 0;
        for (int num : arr) {
            if (num == elem)
                cnt++;
        }
        return cnt;
    }

    public static int majorityElement(int[] v) {
        int elem = 0, c = 0;
        for (int i = 0; i < v.length; i++) {
            if (c == 0) {
                elem = v[i];
            }
            if (elem != v[i])
                c--;
            else
                c++;
        }

        return (count(v, elem) > v.length / 2) ? elem : -1;
    }

    // elements which appear more than n/3 times
    // maximum can be 2 elem min 0 elem;
    public static List<Integer> majorityElementII(int arr[]) {
        int elem1 = 0, elem2 = 0, c1 = 0, c2 = 0, n = arr.length;

        for (int num : arr) {
            if (c1 == 0 && elem2 != num)
                elem1 = num;
            else if (c2 == 0 && elem1 != num)
                elem2 = num;

            if (elem1 == num)
                c1++;
            else if (elem2 == num)
                c2++;
            else {
                c1--;
                c2--;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count(arr, elem1) > n / 3) {
            result.add(elem1);
        }
        if (count(arr, elem2) > n / 3) {
            result.add(elem2);
        }

        return result;
    }

    public static void main(String[] args) {
        // int arr[] = { 7, 7, 5, 5, 4, 3, 5, 7, 7, 7, 5, 4, 6, 7, 7, 7, 7 };
        int arr[] = { 1, 1, 1, 3, 3, 2, 2, 2 };
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementII(arr));
    }
}

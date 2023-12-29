package utilities;

import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int copy[] = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(copy).min().getAsInt());

    }
}

package utilities;

import java.util.*;

public class Stream {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(Arrays.stream(arr).max().getAsInt());
        // multiplying all the elements
        System.out.println(Arrays.stream(arr).reduce(1, (a, b) -> a * b));
    }
}

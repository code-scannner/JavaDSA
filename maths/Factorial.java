package maths;

import java.util.*;

public class Factorial {

    public static int fact(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i);
        }
        return result;
    }

    public static int fact(int n, int range) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % range;
        }

        return (int) result;
    }

    public static int fact(int n, List<Integer> groups, int range) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % range;
        }

        for (int i : groups) {
            result = (result * Modulus.modin(fact(i, range), range)) % range;
        }
        return (int) result;
    }

    public static void main(String[] args) {

        int result = fact(5, Arrays.asList(1, 1, 2, 2, 3), (int) 1e9 + 7);
        System.out.println(result);
    }
}

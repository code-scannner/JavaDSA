package leetcode;

import java.util.*;

public class leet_1239 {

    public static int countBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >> 1;
        }
        return count;
    }

    public static int solve(List<Integer> bits, List<Integer> countbits, int i, int prev) {
        if (i == -1)
            return 0;

        int take = Integer.MIN_VALUE;
        if ((prev & bits.get(i)) == 0) {
            take = countbits.get(i) + solve(bits, countbits, i - 1, prev | bits.get(i));
        }
        int discard = solve(bits, countbits, i - 1, prev);

        return Math.max(take, discard);
    }

    public static int maxLength(List<String> arr) {
        List<Integer> bits = new ArrayList<>();
        for (String str : arr) {
            int num = 0;
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if ((1 << (c - 'a') & num) == 0) {
                    num = num | 1 << (c - 'a');
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                bits.add(num);
        }

        List<Integer> countbits = new ArrayList<>();
        for (int bit : bits)
            countbits.add(countBits(bit));

        return solve(bits, countbits, bits.size() - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("cha", "r", "act", "ers")));
    }
}

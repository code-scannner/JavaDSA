package leetcode;

import java.util.*;

import maths.Factorial;

public class leet_2514 {

    static int mod = (int) 1e9 + 7;

    public static int count(String s) {
        int dp[] = new int[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int count : dp) {
            if (count != 0)
                list.add(count);
        }


        return Factorial.fact(s.length(), list, mod);
    }

    public static int countAnagrams(String s) {
        long result = 1L;
        for (String str : s.split(" ")) {
            result = (int) ((result * count(str)) % mod);
        }

        return (int) result;
    }

    public static void main(String[] args) {
        // String str = "too hot";
        String str = "smuiquglfwdepzuyqtgujaisius ithsczpelfqp rjm";
        System.out.println(countAnagrams(str));
    }
}

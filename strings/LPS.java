package strings;

import java.util.*;

public class LPS {
    
    // lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of pat[0..i]. 
    // proper prefix is the one which is not empty and not contains the whole string
    
    public static int[] lps(String s) {
        int n = s.length();
        int[] arr = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                arr[i++] = ++len;
            } else {
                if (len != 0)
                    len = arr[len - 1];
                else
                    i++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String str = "aaacaaaa";
        System.out.println(Arrays.toString(lps(str)));
    }
}

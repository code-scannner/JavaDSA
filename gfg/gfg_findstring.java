package gfg;
import java.util.*;

public class gfg_findstring {
    public static String findString(int n, int k) {
        // 0 0 1 0 2 1 1 2 2 0
        int total = n - 1 + (int) Math.pow(k, n);
        System.out.println("total = " + total);
        StringBuilder str = new StringBuilder(total);
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++)
            str.append(0);
        set.add(str.toString());

        for (int i = n; i < total; i++) {
            for (int j = n - 1; j >= 0; j--) {
                str.append(j);
                String found = str.substring(i - n + 1);
                System.out.println(found);
                if (!set.contains(found)) {
                    set.add(found);
                    break;
                }
                str.deleteCharAt(i);
            }
        }
        return str.toString();

    }

    public static void main(String[] args) {
        int n = 2, k = 3;
        String result = findString(n,k);
        System.out.println(result);
    }
}
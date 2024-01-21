package leetcode;

import java.util.*;

public class leet_93 {
    static List<String> list = new ArrayList<>();
    static List<String> result = new ArrayList<>();

    public static void restoreIp(String s, int i, int n) {

        if (list.size() == 4) {
            if (i == n) {
                StringBuilder str = new StringBuilder();
                for (String ip : list) {
                    str.append(ip);
                    str.append('.');
                }

                result.add(str.substring(0, str.length() - 1).toString());
            }
            return;
        }
        if(i == n) return;
        if (s.charAt(i) == '0') {
            list.add("0");
            restoreIp(s, i + 1, n);
            list.remove(list.size() - 1);
        } else {
            for (int cnt = 1; cnt <= 3 && i + cnt <= n && Integer.parseInt(s.substring(i, i + cnt)) <= 255; cnt++) {
                list.add(s.substring(i, i + cnt));
                restoreIp(s, i + cnt, n);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n > 12 || n < 4)
            return result;
        restoreIp(s, 0, n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("01220115"));
    }
}

package striverCP.implement;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        StringBuilder str = new StringBuilder(t);
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (i == 0 && num == 9)
                continue;
            if (num >= 5) {
                num = 9 - num;
            }
            str.setCharAt(i, (char) (num + '0'));
        }
        System.out.println(str);
        sc.close();
    }
}

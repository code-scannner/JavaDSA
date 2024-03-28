package codeforces.Round937;

import java.util.*;

public class C {
    public static String sol(String time) {
        String t[] = time.split(":");
        int hr = Integer.valueOf(t[0]);
        String format = "AM";
        if (hr == 0) {
            hr = 12;
            format = "AM";
        } else if (hr > 12) {
            hr -= 12;
            format = "PM";
        } else if (hr == 12)
            format = "PM";
        StringBuilder result = new StringBuilder(time);
        result.setCharAt(1, (char) ((hr % 10) + '0'));
        result.setCharAt(0, (char) ((hr / 10) + '0'));
        result.append(" ");
        result.append(format);

        return result.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            System.out.println(sol(a));
        }
        sc.close();
    }
}

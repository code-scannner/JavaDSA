package codeforces.Round944;

import java.util.Scanner;

public class D {
    public static int sol(String s) {
        int i = 0, count = 0;
        boolean bitChange = false;
        while(i < s.length()){
            if(i != 0 && s.charAt(i) != s.charAt(i - 1)) count++;
            if(i != 0 && s.charAt(i) == '1' && s.charAt(i - 1) == '0') bitChange = true;
            i++;
        }
        return count + (bitChange ? 0 : 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String ax = sc.next();
            System.out.println(sol(ax));
        }
        sc.close();
    }
}

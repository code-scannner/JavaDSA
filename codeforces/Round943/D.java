package codeforces.Round943;

import java.util.*;

public class D {
    public static long maxSol(int n, int k, int per[], int score[], int pos) {
        long max = Integer.MIN_VALUE;
        long currSum = 0;
        int i = 1;
        while (n > 0) {
            currSum += score[pos - 1];
            max = Math.max(max, currSum + score[pos - 1] * (long)(k - i++));
            n--;
            pos = per[pos - 1];
        }
        return max;
    }

    public static String sol(int n, int k, int pb, int ps, int per[], int score[]) {
        int m = Math.min(n, k);
        long bodya = maxSol(m, k, per, score, pb);
        long sasha = maxSol(m, k, per, score, ps);
        if (bodya == sasha)
            return "Draw";
        else if (bodya > sasha)
            return "Bodya";
        else
            return "Sasha";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int pb = sc.nextInt();
            int ps = sc.nextInt();
            int per[] = new int[n];
            for (int j = 0; j < n; j++) {
                per[j] = sc.nextInt();
            }
            int score[] = new int[n];
            for (int j = 0; j < n; j++) {
                score[j] = sc.nextInt();
            }
            System.out.println(sol(n, k, pb, ps, per, score));
        }
        sc.close();
    }

}

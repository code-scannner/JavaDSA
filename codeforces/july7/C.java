package codeforces.july7;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = sc.narr(n), b[] = sc.narr(n), c[] = sc.narr(n);
            long total = 0;
            for (int num : a)
                total += num;
            total = (long) Math.ceil((double) total / 3);
            int dp[][][] = new int[n][8][3];
            for (int mat[][] : dp) {
                for (int arr[] : mat) {
                    Arrays.fill(arr, -1);
                }
            }


            boolean isPossible = memo(dp, 0, a, b, c, 0, total);
            if (!isPossible)
                out.println(-1);
            else {
                int la = 0, ra = 0, lb = 0, rb = 0, lc = 0, rc = 0;
                int j = 0, comb = 0;
                for (int i = 0; i < 3; i++) {
                    int ai = j, bi = dp[j][comb][0];
                    int index = dp[j][comb][1];
                    if (index == 0) {
                        lc = ai;
                        rc = bi - 1;
                    } else if (index == 1) {
                        lb = ai;
                        rb = bi - 1;
                    } else {
                        la = ai;
                        ra = bi - 1;
                    }
                    comb = dp[j][comb][2];
                    j = bi;
                }

                out.printf("%d %d %d %d %d %d\n", la + 1, ra + 1, lb + 1, rb + 1, lc + 1, rc + 1);
            }
        }

        out.close();
    }

    public static int bitChange(int a) {
        if ((a & 1) == 0)
            return 0;
        else if ((a & 2) == 0)
            return 1;
        else
            return 2;
    }

    public static boolean memo(int dp[][][], int i, int a[], int b[], int c[], int comb, long total) {
        if (i == a.length)
            return comb == 7;

        if (comb == 7)
            return true;

        if (dp[i][comb][0] != -1)
            return dp[i][comb][0] > 0;

        for (int k = 0; k < 3; k++) {
            if ((comb & (1 << k)) == 0) {
                long sum = 0;
                int j = i;
                while (j < c.length && sum < total) {
                    sum += k == 0 ? c[j] : k == 1 ? b[j] : a[j];
                    j++;
                }
                if (sum >= total && memo(dp, j, a, b, c, comb | (1 << k), total)) {
                    dp[i][comb][0] = j;
                    dp[i][comb][1] = k;
                    dp[i][comb][2] = comb | (1<<k);
                    return true;
                }
            }
        }

        dp[i][comb][0] = 0;
        return false;

    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        int[] narr(int n) throws IOException {
            int result[] = new int[n];
            for (int i = 0; i < n; i++)
                result[i] = nextInt();
            return result;
        }

        String[] nstr(int n) throws IOException {
            String result[] = new String[n];
            for (int i = 0; i < n; i++)
                result[i] = next();
            return result;
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}
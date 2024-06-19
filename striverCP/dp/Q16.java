package striverCP.dp;

import java.util.*;
import java.io.*;

// Dp with offset

public class Q16 {
    static int max = 30000 + 1;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), d = sc.nextInt();
        int map[] = new int[max];
        while (n-- > 0) {
            map[sc.nextInt()]++;
        }
        int offset = Math.max(0, d - 250);
        int dp[][] = new int[max][d + 250 - offset];

        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        out.println(memo(dp, d, d, map, offset));

        out.close();
    }

    public static int memo(int dp[][], int i, int l, int map[], int offset) {
        if (i >= max)
            return 0;

        if (dp[i][l - offset] != -1)
            return dp[i][l - offset];
        int res = map[i];
        int rest2 = Math.max(
                memo(dp, i + l, l, map, offset),
                memo(dp, i + l + 1, l + 1, map, offset));
        if (l != 1)
            res += Math.max(rest2,
                    memo(dp, i + l - 1, l - 1, map, offset));
        else
            res += rest2;

        dp[i][l - offset] = res;
        return res;
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
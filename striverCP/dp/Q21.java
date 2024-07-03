package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q21 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        char[] str = sc.next().toCharArray();
        n = str.length;
        m = sc.nextInt();
        long dp[][] = new long[1 << n][m];
        for (long arr[] : dp)
            Arrays.fill(arr, -1L);

        out.println(memo(dp, str, 0, 0, 0));

        out.close();
    }

    public static long memo(long dp[][], char[] str, int i, int rem, int bit) {
        if (i == n)
            return rem == 0 ? 1 : 0;
        if (dp[bit][rem] != -1)
            return dp[bit][rem];
        long count = 0;
        for (int j = 0; j < str.length; j++) {
            if (((1 << j) & bit) == 0) {
                if(i == 0 && str[j] == '0') continue;
                bit = bit | (1 << j);
                count += memo(dp, str, i + 1, (rem * 10 + (str[j] - '0')) % m, bit);
                bit = bit ^ (1 << j);
            }
        }

        dp[bit][rem] = count;
        return count;
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
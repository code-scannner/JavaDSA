package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long l = sc.nextLong(), r = sc.nextLong();
            out.println((count(r) - count(l - 1)) + " ");
        }

        out.close();
    }

    public static long count(long[][][] dp, int idx, int cnt, int tight, List<Integer> digits) {
        if (idx == -1)
            return 1;

        if (cnt == 3)
            return 1;

        if (dp[idx][cnt][tight] != -1)
            return dp[idx][cnt][tight];

        long ret = 0L;
        int k = tight == 1 ? digits.get(idx) : 9;
        for (int i = 0; i <= k; i++) {
            ret += count(dp,
                    idx - 1,
                    cnt + (i != 0 ? 1 : 0),
                    digits.get(idx) == i ? tight : 0,
                    digits);
        }

        dp[idx][cnt][tight] = ret;

        return ret;

    }

    public static long count(long num) {
        
        if(num == 0) return 1;
        
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add((int) (num % 10));
            num /= 10;
        }

        long[][][] dp = new long[digits.size()][3][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1L);
            }
        }

        return count(dp, digits.size() - 1, 0, 1, digits);

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
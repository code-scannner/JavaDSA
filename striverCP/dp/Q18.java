package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q18 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        long l = sc.nextLong();
        long r = sc.nextLong();
        out.println(count(Long.toString(r).toCharArray()) - count(Long.toString(l - 1).toCharArray()));
        out.close();
    }

    public static long count(char[] number) {
        long dp[][][] = new long[number.length][10][2];
        for (long mat[][] : dp) {
            for (long arr[] : mat) {
                Arrays.fill(arr, -1);
            }
        }

        return memo(dp, number, 0, 0, 1);
    }

    public static long memo(long[][][] dp, char[] number, int i, int firstDigit, int tight) {

        if (i == number.length - 1) {
            if (firstDigit == 0)
                return tight == 0 ? 9 : number[i] - '0';
            if (tight == 1 && firstDigit > number[i] - '0')
                return 0;
            return 1;
        }

        if (dp[i][firstDigit][tight] != -1)
            return dp[i][firstDigit][tight];

        int end = tight == 1 ? number[i] - '0' : 9;
        long res = 0;
        for (int j = 0; j <= end; j++) {
            res += memo(dp, number, i + 1, firstDigit == 0 ? j : firstDigit, tight == 1 && j == end ? 1 : 0);
        }

        dp[i][firstDigit][tight] = res;

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
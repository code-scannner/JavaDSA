package codeforces.july18;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt();
            int arr[] = sc.narr(n);

            long prefix[] = new long[n + 1];
            long dp[] = new long[n + 3];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + arr[i];
            }

            int result = 0;
            for (int i = n - 1; i >= 0; i--) {
                long val = prefix[i] + x;
                int idx = lowerBound(prefix, val);

                if (idx == n + 1)
                    dp[i] += n - i;
                else if (val == prefix[idx])
                    dp[i] += (idx - i) + dp[idx + 1];
                else
                    dp[i] += (idx - i - 1) + dp[idx];
            }

            for (int i = 0; i <= n + 2; i++) {
                result += dp[i];
            }

            out.println(result);
        }

        out.close();
    }

    public static int lowerBound(long arr[], long target) {
        int ans = arr.length;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
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
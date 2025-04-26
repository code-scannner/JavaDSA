package codeforces.april19;

import java.util.*;
import java.io.*;

public class D {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sex = 0;
            int sexy = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                sex ^= x;
                sexy ^= (x + y);
            }

            int s = sex;
            int t_value = sexy - s;
            out.println(s + " " + t_value);

        }

        out.close();
    }

    static long solve(int[][] mat, int[] cost, boolean rowMode) {
        int n = cost.length;
        long[][] dp = new long[n][2]; // 0: don't hire, 1: hire
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);

        for (int hire = 0; hire <= 1; hire++) {
            dp[0][hire] = hire == 0 ? 0 : cost[0];
        }

        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev <= 1; prev++) {
                for (int curr = 0; curr <= 1; curr++) {
                    boolean valid = true;
                    for (int j = 0; j < n; j++) {
                        int h1 = rowMode ? mat[i - 1][j] + prev : mat[j][i - 1] + prev;
                        int h2 = rowMode ? mat[i][j] + curr : mat[j][i] + curr;
                        if (h1 == h2) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        dp[i][curr] = Math.min(dp[i][curr], dp[i - 1][prev] + (curr == 1 ? cost[i] : 0));
                    }
                }
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
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

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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

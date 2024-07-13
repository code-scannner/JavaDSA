package codeforces.july11;

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int MAX = (int)1e9;
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            String str = sc.next();
            char path[] = ("L" + str).toCharArray();
            int dp[] = new int[path.length];
            for (int i = path.length - 1; i >= 0; i--) {
                if (path[i] == 'C')
                    dp[i] = MAX;
                if (path[i] == 'L') {
                    // then i can jump;
                    if(i + m >= n + 1) continue;
                    dp[i] = MAX;
                    for(int j = i + 1; j<=i + m;j++){
                        dp[i] = Math.min(dp[i], dp[j]);
                    }

                } else if (path[i] == 'W') {
                    if(i + 1 == n + 1) dp[i] = 1;
                    else dp[i] = 1 + dp[i + 1];
                }
            }

            out.println(dp[0] <= k ? "YES" : "NO");
        }

        out.close();
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
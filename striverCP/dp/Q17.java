package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q17 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = 1;
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int arr[] = sc.narr(n);
            if (n > m)
                out.println("YES");
            else {
                boolean dp[] = new boolean[m];
                boolean isPossible = false;
                for (int num : arr) {
                    int rem = num % m;
                    boolean next[] = new boolean[m];
                    for (int i = 0; i < m; i++) {
                        if (dp[i]) {
                            next[(rem + i) % m] = true;
                        }
                    }
                    dp[rem] = true;

                    for(int i = 0; i<m; i++){
                        dp[i] = next[i] | dp[i];
                    }
                    if (dp[0]) {
                        isPossible = true;
                        break;
                    }
                }

                out.println(isPossible ? "YES" : "NO");
            }
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
package codeforces.july26;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        int mod = (int) 1e9 + 7;
        while (t-- > 0) {
            char[] str = sc.next().toCharArray();
            int n = str.length;
            int[] arr = new int[str.length];
            for (int i = 0; i < n; i++) {
                if (str[i] == '0')
                    arr[i] = -1;
                else
                    arr[i] = 1;
            }

            long ans = 0;
            int index [] = new int[2*n + 1];
            int prev = 0;
            for (int i = 1; i <= n; i++) {
                int pre = prev + arr[i - 1];
                index[prev + n] = (int)(((long)index[prev + n] + i)%mod);
                ans += ((long)index[pre + n]* (n - i + 1))%mod;
                prev = pre;
            }

            out.println(ans);

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
package codeforces.aug6;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), s = sc.nextInt(), m = sc.nextInt();
            int intervals[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i] = sc.narr(2);
            }
            boolean isPossible = false;
            int prev = 0;
            for (int i = 0; i < n; i++) {
                int curr = intervals[i][0];
                if (s <= curr - prev) {
                    isPossible = true;
                    break;
                }
                prev = intervals[i][1];
            }

            if (s <= m - prev) {
                isPossible = true;
            }

            out.println(isPossible ? "YES" : "NO");

        }

        out.close();
    }

    public static int wins(int a1, int a2, int b1, int b2) {
        int cnt = 0;
        if (a1 > b1)
            cnt++;
        if (a2 > b2)
            cnt++;
        return cnt == 2 ? 1 : 0;
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
package codeforces.jan19;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int cows[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                cows[i] = sc.narr(m);
            }
            int[] ans = find(cows, n, m);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }

        out.close();
    }

    public static int[] find(int cows[][], int n, int m) {
        int[] ans = new int[n];
        boolean[] filled = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cards[] = cows[i];
            Arrays.sort(cards);
            if (cards[0] >= n || filled[cards[0]])
                return new int[] { -1 };
            for (int j = 1; j < m; j++) {
                if (cards[j] - cards[j - 1] != n)
                    return new int[] { -1 };
            }
            filled[cards[0]] = true;
            ans[cards[0]] = i + 1;
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
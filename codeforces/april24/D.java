package codeforces.april24;

import java.util.*;
import java.io.*;

public class D {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = sc.narr(n);
            int[] b = sc.narr(m);

            int j = 0;
            for (int i = 0; i < n && j < m; i++)
                if (a[i] >= b[j])
                    j++;

            if (j == m) {
                out.println(0);
                continue;
            }

            int[] px = new int[n + 1];
            j = 0;
            for (int i = 0; i < n; i++) {
                if (j < m && a[i] >= b[j])
                    j++;
                px[i + 1] = j;
            }

            int[] sy = new int[n + 2];
            j = m - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (j >= 0 && a[i] >= b[j])
                    j--;
                sy[i + 1] = m - 1 - j;
            }

            int ans = Integer.MAX_VALUE;
            for (int pos = 0; pos <= n; pos++) {
                int match = px[pos];
                if (match >= m)
                    continue;
                int rem = m - (match + 1);
                if (sy[pos + 1] >= rem) {
                    ans = Math.min(ans, b[match]);
                }
            }

            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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

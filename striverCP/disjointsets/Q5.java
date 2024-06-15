package striverCP.disjointsets;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            char[] str = sc.next().toCharArray();

            // out.println(usingGreedy(n, k, str));
            out.println(usingDFS(n, k, str));


        }

        out.close();
    }

    public static int usingDFS(int n, int k, char[] str) {
        boolean visited[] = new boolean[n];
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                int map[] = new int[127];
                dfs(str, i, k, visited, map);
                dfs2(str, n - 1 - i, k, visited, map);
                int cnt = 0, max = Integer.MIN_VALUE;
                for (int j = 'a'; j <= 'z'; j++) {
                    cnt += map[j];
                    max = Math.max(max, map[j]);
                }

                result += cnt - max;
            }
        }
        return result;

    }

    public static void dfs(char str[], int i, int k, boolean visited[], int map[]) {
        if (i >= str.length || visited[i])
            return;
        map[str[i]]++;
        visited[i] = true;
        dfs(str, i + k, k, visited, map);
    }

    public static void dfs2(char str[], int i, int k, boolean visited[], int map[]) {
        if (i < 0 || visited[i])
            return;
        map[str[i]]++;
        visited[i] = true;
        dfs2(str, i - k, k, visited, map);
    }

    public static int usingGreedy(int n, int k, char[] str) {
        boolean visited[] = new boolean[k];
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                int map[] = new int[127];
                int j, m;
                for (j = i; j < n; j += k) {
                    map[str[j]]++;
                }
                j -= k;
                m = n - 1 - i;
                if (j != m) {
                    for (; m >= 0; m -= k) {
                        map[str[m]]++;
                    }
                    m += k;
                }
                if (m < k)
                    visited[m] = true;
                int cnt = 0, max = Integer.MIN_VALUE;
                for (j = 'a'; j <= 'z'; j++) {
                    cnt += map[j];
                    max = Math.max(max, map[j]);
                }

                result += cnt - max;
            }
        }
        return result;
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
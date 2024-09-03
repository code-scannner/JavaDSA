package codeforces.sep1;

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            char[] s = sc.next().toCharArray();
            boolean visited[] = new boolean[n + 1];
            int ans[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i, 0, visited, ans, s, arr);
                }
            }

            for (int i = 1; i <= n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }

        out.close();
    }

    public static int dfs(int i, int black, boolean visited[], int[] ans, char[] s, int[] perm) {
        if (visited[i])
            return black;
        visited[i] = true;
        black = dfs(perm[i], (s[i - 1] == '0' ? 1 : 0) + black, visited, ans, s, perm);
        ans[i] = black;
        return black;
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
            int result[] = new int[n + 1];
            for (int i = 1; i <= n; i++)
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
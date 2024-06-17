package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q48 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        int mat[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            mat[i] = sc.narr(m);
        int ans[][] = new int[n][m];
        for (int arr[] : ans)
            Arrays.fill(arr, 1);
        if (isPossible(mat, ans, n, m)) {
            out.println("YES");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    out.print(ans[i][j] + " ");
                out.println();
            }
        } else
            out.println("NO");

        out.close();
    }

    public static boolean isPossible(int mat[][], int ans[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < n; k++)
                        ans[k][j] = 0;
                    for (int k = 0; k < m; k++)
                        ans[i][k] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    boolean flag = false;
                    for (int k = 0; k < n; k++) {
                        if (ans[k][j] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag)
                        continue;

                    for (int k = 0; k < m; k++) {
                        if (ans[i][k] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        return false;
                }
            }
        }

        return true;
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
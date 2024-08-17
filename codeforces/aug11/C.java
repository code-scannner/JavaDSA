package codeforces.aug11;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            int xs = sc.nextInt(), ys = sc.nextInt(), xt = sc.nextInt(), yt = sc.nextInt();
            boolean flag = true;
            long minDis = dis(xs, ys, xt, yt);
            for (int cir[] : arr) {
                int x = cir[0], y = cir[1];
                long edis = dis(xt, yt, x, y);
                if (minDis >= edis) {
                    flag = false;
                    break;
                }
            }

            out.println(flag ? "YES" : "NO");
        }

        out.close();
    }

    public static long dis(int x1, int y1, int x2, int y2) {
        return (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);
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
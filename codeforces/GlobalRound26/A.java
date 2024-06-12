package codeforces.GlobalRound26;

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            int prev = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != prev) {
                    cnt++;
                    prev = arr[i];
                }
            }

            if (cnt == 1) {
                out.println("NO");
            } else {
                out.println("YES");
                if (cnt == 2) {
                    if (arr[0] == arr[1]) {
                        out.print('R');
                        for (int i = 1; i < n; i++)
                            out.print('B');
                    } else {
                        out.print("RR");
                        for (int i = 2; i < n; i++)
                            out.print('B');
                    }
                } else {
                    int i = 0;
                    while (arr[i] == arr[0]) {
                        out.print('R');
                        i++;
                    }
                    while (i < n) {
                        out.print('B');
                        i++;
                    }
                }
                out.println();
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
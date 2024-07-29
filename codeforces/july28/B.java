package codeforces.july28;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int b[] = sc.narr(n - 1);
            int a[] = new int[n];
            boolean isPossible = true;
            for (int i = 1; i < n; i++) {
                int tomake = b[i - 1];
                for (int j = 0; j < 30; j++) {
                    int toMakeBit = ((tomake & (1 << j)) == 0) ? 0 : 1;
                    if (toMakeBit != 0) {
                        a[i - 1] |= (1 << j);
                        a[i] |= (1 << j);
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                if ((a[i - 1] & a[i]) != b[i - 1]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int i = 0; i < n; i++)
                    out.print(a[i] + " ");
                out.println();
            } else
                out.println(-1);
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
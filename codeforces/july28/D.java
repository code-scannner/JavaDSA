package codeforces.july28;

import java.util.*;

import maths.Prime;

import java.io.*;

public class D {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int colors[] = new int[n + 1];
            int max = 1;
            for (int i = 1; i <= n; i++) {
                boolean currColors[] = new boolean[n + 1];
                for (int j = 1; j <= n; j++) {
                    if (Prime.checkPrime(i ^ j)) {
                        currColors[colors[j]] = true;
                    }
                }
                int k = 1;
                for (; k <= n; k++) {
                    if (!currColors[k])
                        break;
                }
                max = Math.max(max, k);
                colors[i] = k;
            }
            out.println(max);
            for (int i = 1; i < colors.length; i++) {
                out.print(colors[i] + " ");
            }
            out.println();

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
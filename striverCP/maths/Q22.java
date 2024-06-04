package striverCP.maths;

import java.util.*;
import java.io.*;

public class Q22 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int emotes[] = sc.narr(n);
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (emotes[i] > max) {
                smax = max;
                max = emotes[i];
            } else if (emotes[i] > smax) {
                smax = emotes[i];
            }
        }
        int sn = m / (k + 1);
        long result = (long)sn * smax + (long)(m - sn) * max;
        System.out.println(result);

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
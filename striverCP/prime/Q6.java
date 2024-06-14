package striverCP.prime;

import java.util.*;
import java.io.*;

// Good Question seive of eranthanosis

public class Q6 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int max = (int) 5e6 + 1;
        long factors[] = new long[max + 1];
        for (int i = 2; i <= max; i++) {
            if (factors[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    factors[j] = factors[j / i] + 1;
                }
            }
        }

        for (int i = 1; i < factors.length; i++)
            factors[i] += factors[i - 1];

        int t = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (t-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt();
            str.append(factors[x] - factors[y]);
            str.append("\n");
        }
        out.println(str);

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
package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q32 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int k = sc.nextInt();
        char[] s = sc.next().toCharArray();
        int map[] = new int[127];
        for (char c : s) {
            map[c]++;
        }
        StringBuilder str = new StringBuilder();
        boolean isPossible = true;
        for (int i = 0; i < 127 && isPossible; i++) {
            if (map[i] % k != 0) {
                isPossible = false;
            } else {
                for (int j = map[i] / k; j > 0; j--)
                    str.append((char) i);
            }
        }
        if (isPossible) {
            for (int i = 0; i < k; i++) {
                out.print(str);
            }
        } else
            out.print(-1);

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
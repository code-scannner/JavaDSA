package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q46 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] p = sc.next().toCharArray(), h = sc.next().toCharArray();
            out.println(sol(p, h) ? "YES" : "NO");
        }

        out.close();
    }

    public static boolean sol(char[] p, char[] h) {
        if (p.length > h.length)
            return false;
        String hsh = hash(p, null);
        int map[] = new int[127];
        for (int i = 0; i < h.length; i++) {
            if (i >= p.length)
                map[h[i - p.length]]--;
            map[h[i]]++;
            if (i >= p.length - 1) {
                if (hash(null, map).equals(hsh))
                    return true;
            }
        }

        return false;
    }

    public static String hash(char str[], int map[]) {
        if (map == null) {
            map = new int[127];
            for (char c : str) {
                map[c]++;
            }
        }
        StringBuilder h = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            if (map[i] != 0) {
                h.append((char) i);
                h.append(map[i]);
            }
        }
        return h.toString();
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
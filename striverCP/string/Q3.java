package striverCP.string;

import java.util.*;
import java.io.*;

public class Q3 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String str = sc.next();
            set.add(str);
        }
        while (m-- > 0) {
            String str = sc.next();
            if (isPossible(str, set))
                out.println("YES");
            else
                out.println("NO");
        }

        out.close();
    }

    public static boolean isPossible(String str, Set<String> set) {
        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'c'; c++) {
                if (str.charAt(i) == c)
                    continue;
                s.setCharAt(i, c);
                if (set.contains(s.toString()))
                    return true;

            }
            s.setCharAt(i, str.charAt(i));
        }

        return false;
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
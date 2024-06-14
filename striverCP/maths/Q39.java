package striverCP.maths;

import java.util.*;
import java.io.*;

public class Q39 {
    static PrintWriter out = new PrintWriter(System.out);

    static void ans(boolean yes) {
        if (yes)
            out.println("Yes");
        else
            out.println("No");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();

        int q = sc.nextInt();
        while (q-- > 0) {
            char[] s = sc.next().toCharArray();
            char[] t = sc.next().toCharArray();
            char [] lg = s.length > t.length ? s : t;
            char [] sm = s.length <= t.length ? s : t;

            if (!isPossible(lg, sm)) {
                out.println(-1);
            } else {
                StringBuilder str = new StringBuilder();
                int times = lg.length / hcf(sm.length, lg.length);
                for (int i = 0; i < times; i++) {
                    str.append(sm);
                }
                out.println(str);
            }

        }
        out.close();
    }

    public static int hcf(int d, int rem) {
        if (rem == 0)
            return d;
        return hcf(rem, d % rem);
    }

    public static boolean isPossible(char[] lg, char[] sm) {
        int n = lg.length, m = sm.length;
        int times = n*m/hcf(n, m);
        int i = 0, j = 0;
        while(times > 0){
            if(lg[i] != sm[j]) return false;
            times--;
            i++; j++;
            if(i == n) i = 0;
            if(j == m) j = 0;
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
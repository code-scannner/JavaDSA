package striverCP.binarysearch;

import java.util.*;
import java.io.*;

public class Q1 {
    static class Ingredient {
        int cost;
        int have;
        int needed;
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        String str = sc.next();
        Ingredient[] sausage = new Ingredient[3];

        for (int i = 0; i < 3; i++)
            sausage[i] = new Ingredient();

        for (char c : str.toCharArray()) {
            if (c == 'B')
                sausage[0].needed++;
            else if (c == 'S')
                sausage[1].needed++;
            else
                sausage[2].needed++;
        }

        for (int i = 0; i < 3; i++)
            sausage[i].have = sc.nextInt();
        for (int i = 0; i < 3; i++)
            sausage[i].cost = sc.nextInt();
        long amt = sc.nextLong();

        long left = 0, right = -1;
        for (int i = 0; i < 3; i++) {
            if (sausage[i].needed != 0)
                right = Math.max((sausage[i].have + amt / sausage[i].cost) / sausage[i].needed, right);
        }

        while (left <= right) {
            long mid = (right + left) >> 1;
            if (ans(sausage, mid, amt)) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        out.println(right);

        out.close();
    }

    public static boolean ans(Ingredient[] sausage, long sa, long amt) {
        for (int i = 0; i < 3; i++) {
            long extraAmt = Math.max(0, (sa * sausage[i].needed - sausage[i].have) * sausage[i].cost);
            if (extraAmt > amt)
                return false;
            amt -= extraAmt;
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
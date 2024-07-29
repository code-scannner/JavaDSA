package codeforces.july23;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = sc.narr(n);
            BigInteger max = new BigInteger("1");
            int i = 0;
            while (i < n && arr[i] == 1)
                i++;
            int op = 0;
            for (; i < n; i++) {
                if(arr[i] == 1){
                    op = -1;
                    break;
                }
                BigInteger j = new BigInteger(""+arr[i]);
                while (j.compareTo(max) == -1) {
                    j = j.pow(2);
                    op++;
                }
                max = max.max(j);
            }
            out.println(op);
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

        long[] narr(int n) throws IOException {
            long result[] = new long[n];
            for (int i = 0; i < n; i++)
                result[i] = nextLong();
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
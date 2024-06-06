package codeforces.Round951;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ansAmt = -1;
            int arr[] = sc.narr(n);
            for (int i = n; i <= 20000; i+=n) {
                int sum = i;
                boolean isPossible = true;
                for (int j = 0; j < n; j++) {
                    sum -= (int) Math.ceil((double) (i + 1) / arr[j]);
                    if (sum < 0) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    ansAmt = i;
                    break;
                }
            }

            if (ansAmt == -1)
                out.println(-1);
            else {
                for (int i = 0; i < n; i++) {
                    out.print((int) Math.ceil((double) (ansAmt + 1) / arr[i]) + " ");
                }
                out.println();
            }

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
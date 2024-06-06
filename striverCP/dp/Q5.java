package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = sc.narr(n);
        int min = Integer.MAX_VALUE;
        int prefixSum[] = new int[n + 1];
        int minIdx = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            prefixSum[i + 1] = sum;
            if (i - k + 1 >= 0) {
                if (sum - prefixSum[i - k + 1] < min) {
                    minIdx = i - k + 2;
                    min = sum - prefixSum[i - k + 1];
                }
            }
        }
        out.println(minIdx);

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
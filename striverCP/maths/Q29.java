package striverCP.maths;

import java.util.*;
import java.io.*;

public class Q29 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long max = 0;
            int w = sc.nextInt(), h = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = sc.narr(k);
            Arrays.sort(arr);
            max = Math.max(max, (long) (arr[k - 1] - arr[0]) * h);

            k = sc.nextInt();
            arr = sc.narr(k);
            Arrays.sort(arr);
            max = Math.max(max, (long) (arr[k - 1] - arr[0]) * h);

            k = sc.nextInt();
            arr = sc.narr(k);
            Arrays.sort(arr);
            max = Math.max(max, (long) (arr[k - 1] - arr[0]) * w);

            k = sc.nextInt();
            arr = sc.narr(k);
            Arrays.sort(arr);
            max = Math.max(max, (long) (arr[k - 1] - arr[0]) * w);

            out.println(max);

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
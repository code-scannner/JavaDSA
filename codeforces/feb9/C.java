package codeforces.feb9;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[] = sc.narr(n);
            m = sc.nextInt();
            boolean possible = check(arr);
            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) {
                    int elem = arr[i];
                    arr[i] = m - arr[i];
                    if (check(arr))
                        possible = true;
                    arr[i] = elem;
                    arr[i - 1] = m - arr[i - 1];
                    if (check(arr))
                        possible = true;
                    break;
                }
            }

            out.println(possible ? "YES" : "NO");

        }

        out.close();
    }

    public static boolean check(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
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
package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q50 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), k = sc.nextInt();
        int arr[] = sc.narr(n);
        int a[][] = new int[n][2];
        for(int i = 0;i <n; i++){
            a[i][0] = arr[i];
            a[i][1] = i + 1;
        }
        Arrays.sort(a, (c,b)->c[0] - b[0]);
        int sum = 0;
        int i = 0;
        for (; i < n; i++) {
            sum += a[i][0];
            if (sum > k)
                break;
        }
        out.println(i);
        for (int j = 0; j < i; j++)
            out.print(a[j][1] + " ");
        out.println();

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
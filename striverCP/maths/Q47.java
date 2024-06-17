package striverCP.maths;

import java.util.*;
import java.io.*;

public class Q47 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        shuffle(arr);
        Arrays.sort(arr);
        if (arr[n - 1] >= arr[n - 2] + arr[n - 3])
            out.println("NO");
        else {
            out.println("YES");
            out.print(arr[n - 1] + " ");
            for (int i = n - 3; i >= 0; i--)
                out.print(arr[i] + " ");
            out.println(arr[n - 2]);
        }
        out.close();
    }

    public static void shuffle(int arr[]) {
        Random r = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = r.nextInt(n);
            if (idx != i) {
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
            }
        }
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
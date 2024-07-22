package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q11 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int k = sc.nextInt();
        int n = (1 << k) - 1;
        String str = sc.next();
        char[] arr = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = str.charAt(n - i - 1);
        }

        int seg[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int left = 2 * i + 1;
            if (left >= n)
                seg[i] = arr[i] == '?' ? 2 : 1;
            else {
                int right = left + 1;
                if (arr[i] == '?')
                    seg[i] = seg[left] + seg[right];
                else if (arr[i] == '1')
                    seg[i] = seg[left];
                else
                    seg[i] = seg[right];
            }
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int index = n - sc.nextInt();
            char point = sc.next().toCharArray()[0];
            arr[index] = point;
            int prevIndex = -1;
            while (index != prevIndex) {
                int left = 2 * index + 1;
                if (left >= n)
                    seg[index] = arr[index] == '?' ? 2 : 1;
                else {
                    int right = left + 1;
                    if (arr[index] == '?')
                        seg[index] = seg[left] + seg[right];
                    else if (arr[index] == '1')
                        seg[index] = seg[left];
                    else
                        seg[index] = seg[right];
                }
                prevIndex = index;
                index = (index - 1) / 2; // moving to parent;
            }
            out.println(seg[0]);

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
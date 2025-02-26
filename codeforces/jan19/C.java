package codeforces.jan19;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int arr[] = sc.narr(n);
            Map<Integer, Integer> map = new HashMap<>();
            int score = 0;
            for (int num : arr)
                map.merge(num, 1, Integer::sum);
            for (int i = 1; i < k / 2; i++) {
                score += Math.min(map.getOrDefault(i, 0), map.getOrDefault(k - i, 0));
            }
            if (k % 2 == 0) {
                score += map.getOrDefault(k / 2, 0) / 2;
            }
            else{
                score += Math.min(map.getOrDefault(k/2, 0), map.getOrDefault(k/2 + 1, 0));
            }

            System.out.println(score);
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
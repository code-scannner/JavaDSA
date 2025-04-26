package codeforces.april19;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException, java.lang.Exception {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] s = sc.next().toCharArray();

            int lastB = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (s[i] == 'B') {
                    lastB = i;
                    break;
                }
            }
            if (lastB == -1) {
                out.println(0);
                continue;
            }
            int countP = 0;
            for (int i = 0; i < lastB; i++) {
                if (s[i] == 'P') {
                    countP++;
                }
            }
            out.println(countP);

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

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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

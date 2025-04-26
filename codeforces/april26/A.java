package codeforces.april26;

import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            int[] freq = new int[10];
            for (char c : str.toCharArray()) {
                freq[c - '0']++;
            }

            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                int min_required = 9 - i;
                for (int d = min_required; d <= 9; ++d) {
                    if (freq[d] > 0) {
                        ans.append((char) (d + '0'));
                        freq[d]--;
                        break;
                    }
                }
            }

            out.println(ans);

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

package codeforces.april26;

import java.util.*;
import java.io.*;

public class C {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = sc.narr(n);
            sc.sort(arr);
            Map<Long, Integer> map = new HashMap<>();
            boolean found = false;
            for (long num : arr) {
                int curr = map.getOrDefault(num, 0);
                map.put(num, curr + 1);
                if (curr == 3) {
                    found = true;
                    break;
                }
            }
            if (found) {
                out.println("Yes");
                continue;
            }

            List<Long> unq = new ArrayList<>(map.keySet());
            Collections.sort(unq);
            int cnt = map.get(unq.get(0)) >= 2 ? 1 : 0;
            for (int i = 1; i < unq.size(); i++) {
                if (unq.get(i) == unq.get(i - 1) + 1) {
                    if (map.get(unq.get(i)) >= 2) {
                        cnt++;
                    }
                } else
                    cnt = 0;

                if (cnt == 2) {
                    found = true;
                    break;
                }
            }
            out.println(found ? "Yes" : "No");
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

        long[] narr(int n) throws IOException {
            long result[] = new long[n];
            for (int i = 0; i < n; i++)
                result[i] = nextLong();
            return result;
        }

        void sort(long arr[]) {
            List<Long> list = new ArrayList<>();
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

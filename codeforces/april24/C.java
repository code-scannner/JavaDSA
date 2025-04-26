package codeforces.april24;

import java.util.*;
import java.io.*;

public class C {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = sc.narr(n);
            int[] b = sc.narr(n);

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (b[i] != -1)
                    set.add(a[i] + b[i]);
            }

            if (set.size() > 1) {
                out.println(0);
                continue;
            }

            if (!set.isEmpty()) {
                int x = set.iterator().next();
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if (b[i] == -1) {
                        int bi = x - a[i];
                        if (bi < 0 || bi > k) {
                            valid = false;
                            break;
                        }
                    }
                }
                out.println(valid ? 1 : 0);
            } else {
                int minX = 0;
                int maxX = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    minX = Math.max(minX, a[i]);
                    maxX = Math.min(maxX, a[i] + k);
                }
                int answer = Math.max(0, maxX - minX + 1);
                out.println(answer);
            }
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

package codeforces.april24;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException, java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] p = sc.narr(n);
            int[] pos = new int[n + 1];

            for (int i = 0; i < n; i++) {
                pos[p[i]] = i + 1;
            }

            while (q-- > 0) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int x = sc.nextInt();
                int px = pos[x];

                if (r < px || l > px) {
                    out.print("-1 ");
                    continue;
                }

                int largest = 0, greatest = 0;
                int low = l, high = r;
                int multi = 0, multi2 = 0;
                int M = 0;

                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (mid == px)
                        break;
                    if (mid < px) {
                        if (p[mid - 1] < x)
                            largest++;
                        else {
                            multi++;
                            M++;
                        }
                        low = mid + 1;
                    } else {
                        if (x < p[mid - 1])
                            greatest++;
                        else {
                            multi2++;
                            M++;
                        }
                        high = mid - 1;
                    }
                }

                int item1 = x - 1;
                int item2 = n - x;
                int item3 = item1 - largest;
                int item4 = item2 - greatest;

                if (multi > item3 || multi2 > item4)
                    out.print("-1 ");
                else
                    out.print((M + Math.abs(multi - multi2)) + " ");
            }

            out.println();
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

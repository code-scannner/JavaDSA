package striverCP.stackqueue;

import java.util.*;
import java.io.*;

public class Q4 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int l = 1, r = n;
        SparseTable sg = new SparseTable(arr);
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (ok(mid, arr, n, sg)) {
                l = mid + 1;
            } else
                r = mid - 1;
        }

        List<Integer> list = count(r, arr, n, sg);
        out.println(list.size() + " " + (r - 1)); // r - l is 1 less than the size
        for (int num : list)
            out.print((num + 1) + " "); // 1 based indexing
        out.println();

        out.close();
    }

    public static boolean ok(int size, int arr[], int n, SparseTable sg) {
        int map[] = new int[(int) 1e6 + 1];
        for (int i = 0; i < n; i++) {
            map[arr[i]]++;

            if (i >= size - 1) {
                int totalGcd = sg.query(i - size + 1, i);
                if (map[totalGcd] > 0)
                    return true;
                map[arr[i - size + 1]]--;
            }
        }

        return false;
    }

    public static List<Integer> count(int size, int arr[], int n, SparseTable sg) {
        int map[] = new int[(int) 1e6 + 1];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[arr[i]]++;

            if (i >= size - 1) {
                int totalGcd = sg.query(i - size + 1, i);
                if (map[totalGcd] > 0)
                    list.add(i - size + 1);
                map[arr[i - size + 1]]--;
            }
        }

        return list;
    }

    public static class SparseTable {
        // for range gcd
        int arr[];
        int lookup[][];

        SparseTable(int a[]) {
            int n = a.length;
            arr = a;
            // values stored in lookup is the gcd of the array from index i to i + 2^j - 1;
            lookup = new int[n][1 + (int) Math.ceil(Math.log(n) / Math.log(2))]; // nlogn space

            // building process
            for (int i = 0; i < n; i++) {
                lookup[i][0] = arr[i];
            }
            for (int j = 1; j < lookup[0].length; j++) {
                int gap = (1 << (j - 1));
                for (int i = 0; i + gap + gap <= n; i++) {
                    lookup[i][j] = gcd(lookup[i][j - 1], lookup[i + gap][j - 1]);
                }
            }
        }

        int gcd(int d, int rem) {
            if (rem == 0)
                return d;
            return gcd(rem, d % rem);
        }

        int query(int l, int r) {
            int size = r - l + 1;
            int k = (int) (Math.log(size) / Math.log(2));
            return gcd(lookup[l][k], lookup[l + size - (1 << k)][k]);
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
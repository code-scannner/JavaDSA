package striverCP.fenwick;

import java.util.*;
import java.io.*;

public class Q4 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int ai[] = new int[n], aj[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], val);
            ai[i] = val;
        }
        map.clear();
        for (int i = n - 1; i >= 0; i--) {
            int val = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], val);
            aj[i] = val;
        }

        int indexarr[] = indexedArray(aj);
        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        Arrays.sort(aj);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            // lowerBound = smallest indexed element just greater than target
            int lb = lowerBound(aj, ai[i]);
            ans += bit.sum(lb);
            bit.add(indexarr[i], 1);
        }

        out.println(ans);

        out.close();
    }

    public static int lowerBound(int arr[], int target) {
        int ans = arr.length;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static class BinaryIndexedTree {
        /// 1 indexed tree
        int index[];

        BinaryIndexedTree(int arr[]) {
            index = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                add(i, arr[i]);
            }
        }

        BinaryIndexedTree(int n) {
            index = new int[n + 1];
        }

        public void add(int i, int val) {
            i++; // 1 based indexing
            while (i < index.length) {
                index[i] += val;
                i += i & -i; // moving to child
            }
        }

        public int sum(int i) {
            i++; // 1 based indexing
            int s = 0;
            while (i > 0) {
                s += index[i];
                i -= i & -i; // moving to parent
            }
            return s;
        }

    }

    public static int[] indexedArray(int arr[]) {

        int n = arr.length;
        int index[][] = new int[n][2];
        for (int i = 0; i < n; i++)
            index[i] = new int[] { arr[i], i };

        Arrays.sort(index, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[index[i][1]] = i + 1;
        }
        return res;
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
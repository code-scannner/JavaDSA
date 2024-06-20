package striverCP.fenwick;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        // long ans = usingMergeSort(n, arr);
        // out.println(ans);
        long ans2 = usingBIT(arr, n);
        out.println(ans2);
        out.close();
    }

    public static long usingBIT(int arr[], int n) {
        // number of strictly greater left * number of strictly smaller right => each
        int gl[] = greaterLeft(arr);
        int sr[] = smallerRight(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) gl[i] * sr[i];
        }
        return sum;

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

    public static int[] smallerRight(int arr[]) {
        int n = arr.length;
        int index[] = indexedArray(arr);
        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            bit.add(index[i], 1);
            res[i] = bit.sum(index[i] - 1);
        }
        return res;
    }

    public static int[] greaterLeft(int arr[]) {
        int n = arr.length;
        int index[] = indexedArray(arr);
        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            bit.add(index[i], 1);
            res[i] = i - bit.sum(index[i] - 1);
        }
        return res;
    }

    static class BinaryIndexedTree {
        /// 1 indexed tree
        int index[];

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

    public static long usingMergeSort(int n, int arr[]) {
        int greaterLess[][] = reversePairs(n, arr);
        long pow = 0;
        for (int i = 1; i < n - 1; i++) {
            pow += (long) greaterLess[i][1] * greaterLess[i][0];
        }
        return pow;
    }

    public static int[][] reversePairs(int n, int arr[]) {
        int result[][] = new int[n][2];
        int newarr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            newarr[i][0] = arr[i];
            newarr[i][1] = i;
        }
        mergeSort(result, newarr, 0, n - 1);
        return result;

    }

    public static void mergeSort(int result[][], int arr[][], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(result, arr, l, mid);
            mergeSort(result, arr, mid + 1, r);
            merge(result, arr, l, mid, r);
        }
    }

    public static void merge(int result[][], int arr[][], int l, int mid, int r) {
        int res[][] = new int[r - l + 1][2]; // creating a new array to store
        int left = l, right = mid + 1, k = 0; // initializing pointers
        while (left <= mid || right <= r) { // becomes false if both arrays are empty
            if (left > mid || (right <= r && arr[left][0] > arr[right][0])) {
                // for taking the right maintaining the greater
                result[arr[right][1]][0] += mid - left + 1;
                res[k++] = arr[right++];
            } else {
                // for taking the left maintaing the lesser
                result[arr[left][1]][1] += right - mid - 1;
                res[k++] = arr[left++];
            }
        }

        for (int i = 0, m = l; i < res.length; i++, m++) {
            arr[m] = res[i];
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
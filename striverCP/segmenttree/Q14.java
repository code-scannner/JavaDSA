package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q14 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), q = sc.nextInt();
        int arr[] = sc.narr(n);
        SegmentTree sg = new SegmentTree(arr);
        while (q-- > 0) {
            int type = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            if (type == 2)
                out.println(sg.query(x - 1, y - 1));
            else {
                sg.update(x - 1, y);
            }
        }

        out.close();
    }

    static class Node {
        int leftSub, rightSub;
        long subarrays;

        Node(int min, int max, long s) {
            leftSub = min;
            rightSub = max;
            subarrays = s;
        }

        @Override
        public String toString() {
            return leftSub + " " + rightSub + " " + subarrays;
        }
    }

    static class SegmentTree {
        Node seg[];
        int arr[];
        Node no_overlap_val = new Node(0, 0, -1);

        SegmentTree(int a[]) {
            int n = a.length;
            arr = a;
            seg = new Node[n * 4];
            build(a, 0, 0, n - 1);
        }

        private void build(int arr[], int idx, int low, int high) {
            if (low == high) {
                seg[idx] = new Node(1, 1, 1);
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(arr, left, low, mid);
            build(arr, right, mid + 1, high);
            seg[idx] = eval(seg[left], seg[right], low, mid, high);
        }

        // function used while finding the query values
        public Node eval(Node left, Node right, int low, int mid, int high) {
            if (left.subarrays == -1)
                return right;
            else if (right.subarrays == -1)
                return left;

            Node res = new Node(0, 0, left.subarrays + right.subarrays);
            res.leftSub = left.leftSub;
            res.rightSub = right.rightSub;

            if (arr[mid] <= arr[mid + 1]) {
                res.subarrays += (long) left.rightSub * right.leftSub;
                if (right.leftSub == (high - mid)) {
                    // right subarray is complete with no gaps
                    res.rightSub += left.rightSub;
                }
                if (left.rightSub == mid - low + 1) {
                    // left subarray is complete with no gaps
                    res.leftSub += right.leftSub;
                }
            }

            return res;
        }

        public long query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right).subarrays;
        }

        private Node query(int idx, int low, int high, int l, int r) {
            // no overlap condition
            if (low > r || high < l) {
                return no_overlap_val;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                return seg[idx];
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                return eval(query(left, low, mid, l, r), query(right, mid + 1, high, l, r), low, mid, high);
            }
        }

        // update the index value to another
        public void update(int index, int value) {
            update(0, 0, seg.length / 4 - 1, index, value);
        }

        private void update(int idx, int low, int high, int i, int val) {
            if (low == high) {
                arr[low] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            if (i <= mid)
                update(left, low, mid, i, val);
            else
                update(right, mid + 1, high, i, val);
            seg[idx] = eval(seg[left], seg[right], low, mid, high);
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
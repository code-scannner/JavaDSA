package striverCP.lazypropagation;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        sc.nextInt();
        int m = sc.nextInt();
        char[] str = sc.next().toCharArray();
        LazySegmentTree lsg = new LazySegmentTree(str);
        while (m-- > 0) {
            if (sc.next().equals("count")) {
                out.println(Math.max(Math.max(lsg.seg[0]._44, lsg.seg[0]._47), lsg.seg[0]._77));
            } else {
                int l = sc.nextInt(), r = sc.nextInt();
                lsg.flip(l - 1, r - 1);
            }
        }

        out.close();
    }

    static class Node {
        int _44, _47, _77, _74;

        Node(int fours, int fourSeven, int sevenFour, int sevens) {
            _44 = fours;
            _47 = fourSeven;
            _74 = sevenFour;
            _77 = sevens;
        }
    }

    static class LazySegmentTree {
        Node seg[];
        boolean lazy[];

        LazySegmentTree(char arr[]) {
            seg = new Node[arr.length * 4];
            lazy = new boolean[arr.length * 4];
            build(arr, 0, 0, arr.length - 1);
        }

        // function used while adding left and right intervals
        public Node eval(Node left, Node right) {
            int new47 = Math.max(Math.max(left._44, left._47) + right._77, left._44 + right._47);
            int new74 = Math.max(Math.max(left._77, left._74) + right._44, left._77 + right._74);
            return new Node(
                    left._44 + right._44,
                    new47,
                    new74,
                    left._77 + right._77);
        }

        private void build(char arr[], int idx, int low, int high) {
            if (low == high) {
                seg[idx] = new Node(
                        arr[low] == '4' ? 1 : 0,
                        0,
                        0,
                        arr[low] == '7' ? 1 : 0);
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(arr, left, low, mid);
            build(arr, right, mid + 1, high);
            seg[idx] = eval(seg[left], seg[right]);
        }

        // update the pending values whenever visiting the node
        public void flipLazy(int idx, int l, int r) {
            if (!lazy[idx])
                return;

            // swapping 44's and 77's
            int temp = seg[idx]._44;
            seg[idx]._44 = seg[idx]._77;
            seg[idx]._77 = temp;

            // swapping 47 and 74's
            temp = seg[idx]._47;
            seg[idx]._47 = seg[idx]._74;
            seg[idx]._74 = temp;

            if (l != r) {
                int left = 2 * idx + 1;
                int right = left + 1;
                lazy[left] = !lazy[left];
                lazy[right] = !lazy[right];
            }

            lazy[idx] = false;

        }

        // update the range from l to r adding with value
        public void flip(int l, int r) {
            flip(0, 0, seg.length / 4 - 1, l, r);
        }

        private void flip(int idx, int low, int high, int l, int r) {

            flipLazy(idx, low, high);

            // no overlap condition
            if (low > r || high < l) {
                return;
            }

            // complete overlap
            if (l <= low && high <= r) {
                lazy[idx] = !lazy[idx];
                // updating here is important as we need the update value in the recursion
                flipLazy(idx, low, high);
                return;
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                flip(left, low, mid, l, r);
                flip(right, mid + 1, high, l, r);
                seg[idx] = eval(seg[left], seg[right]);
            }
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
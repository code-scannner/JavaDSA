package codeforces.Round223;

import java.util.*;

// TIME LIMIT EXCEEDED

public class C {
    static class Node {
        int open = 0, close = 0, full = 0;
    }

    static class SegmentTree {
        Node seg[];

        SegmentTree(String bracket) {
            seg = new Node[bracket.length() * 4];
            build(bracket, 0, 0, bracket.length() - 1);
        }

        private void build(String bracket, int idx, int low, int high) {
            if (low == high) {
                seg[idx] = new Node();
                if (bracket.charAt(low) == '(') {
                    seg[idx].open = 1;
                } else
                    seg[idx].close = 1;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(bracket, left, low, mid);
            build(bracket, right, mid + 1, high);
            seg[idx] = eval(seg[left], seg[right]);
        }

        public Node eval(Node left, Node right) {
            Node res = new Node();
            int full = Math.min(left.open, right.close);
            res.open = left.open + right.open - full; // for open
            res.close = left.close + right.close - full; // for close
            res.full = left.full + right.full + full; // for full
            return res;
        }

        public int query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right).full;
        }

        private Node query(int idx, int low, int high, int l, int r) {
            // no overlap condition
            if (low > r || high < l) {
                return new Node();
            }
            // complete overlap
            else if (l <= low && high <= r) {
                return seg[idx];
            }
            // partial overlap
            else {
                int mid = (high + low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                return eval(query(left, low, mid, l, r), query(right, mid + 1, high, l, r));
            }
        }
    }

    public static void sol(String bracket, int[][] queries) {
        SegmentTree sg = new SegmentTree(bracket);
        for (int[] q : queries) {
            System.out.println(2 * sg.query(q[0] - 1, q[1] - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bracket = sc.nextLine();
        int m = sc.nextInt();
        int queries[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        sol(bracket, queries);
        sc.close();
    }
}

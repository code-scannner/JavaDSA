package leetcode;

import tree.Node;

public class leet_1026 {
    static int ans = 0;

    // int[] = {minvalue, maxvalue}
    public static int[] minmax(Node root) {
        if (root == null)
            return new int[] { (int) 1e5 + 1, -1 };

        int[] left = minmax(root.left);
        int[] right = minmax(root.right);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        if (min != (int) 1e5 + 1) {
            ans = Math.max(ans, Math.abs(min - root.val));
        }
        if (max != -1) {
            ans = Math.max(ans, Math.abs(max - root.val));
        }

        return new int[] { Math.min(min, root.val),
                Math.max(max, root.val) };
    }

    public static int maxAncestorDiff(Node root) {
        minmax(root);
        return ans;
    }

    public static void main(String[] args) {
        // Node tree = Node.Tree(new Integer[] {
        // 8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13
        // });
        Node tree = Node.Tree(new Integer[] {
                1, null, 2, null, 0, 3
        });
        System.out.println(maxAncestorDiff(tree));
    }
}
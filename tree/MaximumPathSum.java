package tree;

public class MaximumPathSum {
    private static int maxPathSum(Node root, int[] d) {
        if (root == null)
            return 0;
        
        int left = maxPathSum(root.left, d);
        int right = maxPathSum(root.right, d);
        d[0] = Math.max(d[0], root.val + Math.max(0, left) + Math.max(0, right));
        return root.val + Math.max(0, Math.max(left, right));

    }

    public static int maxPathSum(Node root) {
        int max[] = new int[1];
        maxPathSum(root, max);
        return max[0];

    }

    public static void main(String[] args) {
        
        Node root = Node.Tree(new Integer[] {
                1, 2, 3, null, null, 4, 7, null, 5, null, 8, 6, null, null, 9
        });

        Node root2 = Node.Tree(new Integer[]{
            1
        });

        Node root3 = Node.Tree(new Integer[]{
            1,2,3,4,5,6,7,8
        });

        System.out.println(maxPathSum(root));
        System.out.println(maxPathSum(root2));
        System.out.println(maxPathSum(root3));
    }
}

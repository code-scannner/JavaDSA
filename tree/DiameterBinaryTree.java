package tree;

public class DiameterBinaryTree {
    private static int diameter(Node root, int[] d) {
        if (root == null)
            return 0;
        
        int left = diameter(root.left, d);
        int right = diameter(root.right, d);
        d[0] = Math.max(left + right + 1, d[0]);
        return 1 + Math.max(left, right);

    }

    public static int maxDiameter(Node root) {
        int diameter[] = new int[1];
        diameter(root.left, diameter);
        diameter(root.right, diameter);
        return diameter[0];

    }

    public static void main(String[] args) {
        Node root = Node.Tree(new Integer[] {
                1, 2, 3, null, null, 4, 7, null, 5, null, 8, 6, null, null, 9
        });
        System.out.println(maxDiameter(root));
    }
}

package tree;

public class Check {
    public static int balancedBinaryTree(Node root) {
        if (root == null)
            return 0;

        int left = balancedBinaryTree(root.left);
        int right = balancedBinaryTree(root.right);

        if (left == -1 || right == -1 || Math.abs(right - left) > 1)
            return -1;

        return 1 + Math.max(left, right);

    }

    public static boolean identicalTrees(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return root1.val == root2.val && identicalTrees(root1.left, root2.left)
                && identicalTrees(root1.right, root2.right);
    }

    public static void main(String[] args) {

        Node root = Node.Tree(new Integer[] {
                3, 9, 20, null, null, 15, 7
        });

        Node root2 = Node.Tree(new Integer[] {
                1, 3, 2, 5, 4, null, null, 7, 6
        });

        System.out.println(balancedBinaryTree(root) != -1);
        System.out.println(balancedBinaryTree(root2) != -1);
        System.out.println();

        Node root3 = Node.Tree(new Integer[] {
                1, 3, 2, 5, 4, null, null, 7, 6
        });
        System.out.println(identicalTrees(root, root2));
        System.out.println(identicalTrees(root3, root2));

    }
}

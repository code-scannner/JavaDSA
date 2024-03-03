package tree;

public class Traversal2Tree {
    static int steps = 0;

    public static Node prePostOrder(int[] preorder, int[] postorder, int i, int j, int n) {
        if(n <= 0) return null;
        if (n == 1)
            return new Node(preorder[i]);
        Node root = new Node(preorder[i]);
        int cnt = 0;
        for (int k = j - 1; k > j - n; k--) {
            if (postorder[k] == preorder[i + 1])
                break;
            cnt++;
        }

        root.left = prePostOrder(preorder, postorder, i + 1, j - 1 - cnt, n - 1 - cnt);
        root.right = prePostOrder(preorder, postorder, i + n - cnt, j - 1, cnt);
        return root;

    }

    public static Node preInOrder(int[] preorder, int[] inorder, int i, int j, int n) {
        if (n <= 0)
            return null;
        Node root = new Node(preorder[i]);
        int cnt = 0;
        for (int k = j; k < j + n; k++) {
            if (inorder[k] == preorder[i])
                break;
            cnt++;
        }

        root.left = preInOrder(preorder, inorder, i + 1, j, cnt);
        root.right = preInOrder(preorder, inorder, i + 1 + cnt, j + 1 + cnt, n - cnt - 1);
        return root;
    }

    public static Node postInOrder(int[] postorder, int[] inorder, int i, int j, int n) {
        if (n <= 0)
            return null;
        Node root = new Node(postorder[i + n - 1]);
        int cnt = 0;
        for (int k = j; k < j + n; k++) {
            if (inorder[k] == postorder[i + n - 1])
                break;
            cnt++;
        }

        root.left = postInOrder(postorder, inorder, i, j, cnt);
        root.right = postInOrder(postorder, inorder, i + cnt, j + 1 + cnt, n - cnt - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 10, 20, 40, 50, 30, 60 };
        int[] inorder = { 40, 20, 50, 10, 60, 30 };
        int[] postorder = { 40, 50, 20, 60, 30, 10 };

        Node root = preInOrder(preorder, inorder, 0, 0, preorder.length);
        System.out.println(Node.preOrder(root));
        System.out.println(Node.inOrder(root));
        System.out.println();

        Node rooot = postInOrder(postorder, inorder, 0, 0, postorder.length);
        System.out.println(Node.postOrder(rooot));
        System.out.println(Node.inOrder(rooot));
        System.out.println(Node.preOrder(rooot));
        System.out.println();

        Node roooot = prePostOrder(preorder, postorder, 0, postorder.length - 1, postorder.length);
        System.out.println(Node.preOrder(roooot));
        System.out.println(Node.postOrder(roooot));
        System.out.println(Node.inOrder(roooot));
        System.out.println();
    }
}

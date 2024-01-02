package tree;

public class Traversal2Tree {
    static int steps = 0;

    public static Node preInOrder(int pre[], int in[], int i, int j, int l) {

        if (l <= 0)
            return null;
        Node root = new Node(pre[i]);
        if (l == 1)
            return root;

        int pos = j;
        while (in[pos] != pre[i]) {
            pos++;
        }
        int leftLength = pos - j;
        int rightLength = l - leftLength - 1;
        root.left = preInOrder(pre, in, i + 1, j, leftLength);
        root.right = preInOrder(pre, in, i + leftLength + 1, pos + 1, rightLength);

        return root;
    }

    public static Node postInOrder(int post[], int in[], int i, int j, int l) {
        if (l <= 0)
            return null;
        Node root = new Node(post[i]);
        if (l == 1)
            return root;

        int pos = j;
        while (in[pos] != post[i]) {
            pos++;
        }
        int leftLength = pos - j;
        int rightLength = l - leftLength - 1;

        root.left = postInOrder(post, in,i - rightLength - 1,j, leftLength);
        root.right = postInOrder(post, in,i - 1,pos + 1, rightLength);

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

        Node rooot = postInOrder(postorder, inorder, postorder.length - 1, 0, postorder.length);
        System.out.println(Node.postOrder(rooot));
        System.out.println(Node.inOrder(rooot));
        System.out.println(Node.preOrder(rooot));
        System.out.println();
    }
}

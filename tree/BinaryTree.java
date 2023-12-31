package tree;

public class BinaryTree {

    public static void main(String[] args) {

        Integer tree[] = { 1, 2, 7, 3, 4, null, null, null, null, 5, 6 };

        Node root = Node.Tree(tree);
        Node rooot = Node.Tree(new Integer[] {
                1, 2, 3, 4, 10, 9, 10, null, 5, null, null, null, null, null, null, 6, 7, 8
        });

        System.out.println(Node.preOrder(root));
        System.out.println(Node.inOrder(root));
        System.out.println(Node.postOrder(root));
        System.out.println(Node.BFStraversal(root));
        System.out.println();

        System.out.println(Node.BFStraversal(rooot));
        System.out.println();

        System.out.println(Node.verticalTraversal(rooot));
        System.out.println(Node.verticalUsingPQ(rooot));
    }
}

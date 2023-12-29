package tree;

public class BinaryTree {

    public static void main(String[] args) {

        Integer tree[] = { 1, 2, 7, 3, 4, null, null, null, null, 5, 6 };
        Node root = Node.Tree(tree);
        System.out.println(Node.preOrder(root));
        System.out.println(Node.inOrder(root));
        System.out.println(Node.postOrder(root));
        System.out.println(Node.BFS(root));
    }
}

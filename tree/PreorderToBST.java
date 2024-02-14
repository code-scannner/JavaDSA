package tree;

public class PreorderToBST {
    public static Node divideConquer(int arr[], int i, int j) {
        if (i > j)
            return null;
        Node node = new Node(arr[i]);
        int x = i + 1;
        while (x <= j && arr[x] < arr[i])
            x++;
        node.left = divideConquer(arr, i + 1, x - 1);
        node.right = divideConquer(arr, x, j);
        return node;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 5, 1, 7, 10, 12 };
        Node tree = divideConquer(arr, 0, arr.length - 1);
        System.out.println(Node.preOrder(tree));
        System.out.println(Node.postOrder(tree));
        System.out.println(Node.inOrder(tree));
    }
}

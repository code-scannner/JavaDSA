package tree;

public class InorderToBST {
    public static Node toBST(int[] arr, int i, int j) {

        if (i > j)
            return null;

        if (i == j)
            return new Node(arr[i]);

        int mid = i + (j - i) / 2;
        return new Node(arr[mid], toBST(arr, i, mid - 1), toBST(arr, mid + 1, j));

    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        Node tree = toBST(arr, 0, arr.length - 1);
        System.out.println(Node.Serialize(tree));
    }
}

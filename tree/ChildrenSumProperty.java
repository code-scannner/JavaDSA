package tree;

public class ChildrenSumProperty {
    public static int childSumProperty(Node root, int need) {
        if (root == null)
            return need;

        root.val += need;

        int sum = 0;

        if (root.left != null)
            sum += root.left.val;
        if (root.right != null)
            sum += root.right.val;

        int req = root.val - sum >= 0 ? root.val - sum : 0;

        if (root.left == null) {
            root.val = childSumProperty(root.right, req);
        } else if (root.right == null) {
            root.val = childSumProperty(root.left, req);
        } else {
            root.val = childSumProperty(root.left, req / 2) +
                    childSumProperty(root.right, (req + 1) / 2);
        }

        return root.val;
    }

    public static void main(String[] args) {
        Integer tree[] = { 2, 35, 10, null, 3, 5, 2 };
        Node root = Node.Tree(tree);
        System.out.println(Node.BFStraversal(root));
        childSumProperty(root, 0);
        System.out.println(Node.BFStraversal(root));
        System.out.println();
    }
}

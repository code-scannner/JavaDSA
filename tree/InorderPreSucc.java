package tree;

public class InorderPreSucc {
    public static void inorderSuccessor(Node root, int val, Node[] ans) {
        if(root == null) return;
        if (root.val > val) {
            ans[0] = root;
            inorderSuccessor(root.left, val, ans);
            return;
        }
        inorderSuccessor(root.right, val, ans);
    }

    public static Node inorderSuccessor(Node root, int val) {
        Node [] ans = {null};
        inorderSuccessor(root, val, ans);
        return ans[0];
    }
    public static void inorderPredecessor(Node root, int val, Node[] ans) {
        if(root == null) return;
        if (root.val < val) {
            ans[0] = root;
            inorderPredecessor(root.right, val, ans);
            return;
        }
        inorderPredecessor(root.left, val, ans);
    }

    public static Node inorderPredecessor(Node root, int val) {
        Node [] ans = {null};
        inorderPredecessor(root, val, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        Node tree = PreorderToBST.divideConquer(new int[] { 5, 3, 2, 4, 7, 6, 9, 8, 10 }, 0, 8);
        System.out.println(Node.preOrder(tree));
        System.out.println(inorderSuccessor(tree,8));
        System.out.println(inorderPredecessor(tree,8));
        System.out.println(inorderSuccessor(tree,10));
        System.out.println(inorderPredecessor(tree,10));
        System.out.println(inorderPredecessor(tree,2));
    }
}

package tree;

public class CompleteBinaryTree {
    public static int[] leftRightHeight(Node root) {
        int left = 0, right = 0;

        Node curr = root;
        while(curr != null){
            curr = curr.left;
            left++;
        }

        curr = root;
        while (curr != null) {
            curr = curr.right;
            right++;
        }

        return new int[]{left, right};

    }
    public static int countNodes(Node root) {
        if(root == null) return 0;

        int [] heights = leftRightHeight(root);
        
        if(heights[0] == heights[1]){
            return (int)Math.pow(2,heights[0]) - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public static void main(String[] args) {
        Integer tree[] = { 3, 5, 1, 6, 2, 0, 8, 7, 4 };
        Node root = Node.Tree(tree);
        System.out.println(Node.BFStraversal(root));
        System.out.println(countNodes(root));
    }
}

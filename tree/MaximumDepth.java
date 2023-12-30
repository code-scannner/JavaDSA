package tree;

public class MaximumDepth {
    public static int maxDepth(Node root) {
        if(root == null) return -1;
        
        return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }
    public static void main(String[] args) {
        Node root = Node.Tree(new Integer[]{
            1,2,3,4,5,6,7,8
        });
        Node root2 = Node.Tree(new Integer[]{
            1
        });
        System.out.println(maxDepth(root));
        System.out.println(maxDepth(root2));
    }
}

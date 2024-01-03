package tree;

public class BinarySearchTree {
    public static Node find(Node root, int target) {

        // Iterative approach
        while (root != null && root.val != target) {
            if (root.val > target)
                root = root.left;
            else
                root = root.right;
        }
        return root;

    }

    public static int ceil(Node root, int target) {
        int ans = -1;
        while (root != null) {
            if (root.val == target)
                return target;
            else if (target > root.val) {
                root = root.right;
            } else {
                ans = root.val;
                root = root.left;
            }
        }

        return ans;
    }

    public static int floor(Node root, int target) {
        int ans = -1;
        while (root != null) {
            if (root.val == target)
                return target;
            else if (target > root.val) {
                ans = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return ans;
    }

    public static boolean validate(Node root) {
        
        if(root.left != null){
            if(root.val <= root.left.val || !validate(root.left)) return false;
        }
        if(root.right != null){
            if(root.val >= root.right.val || !validate(root.right)) return false; 
        }

        return true;
    }

    public static void main(String[] args) {
        Node root = Node.Tree(new Integer[] {
                8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13
        });
        // System.out.println(find(root, 13));
        // System.out.println(find(root, 15));
        // System.out.println(find(root, 7));
        // System.out.println();

        // System.out.println(ceil(root, 3));
        // System.out.println(ceil(root, 9));
        // System.out.println(ceil(root, 22));
        // System.out.println();

        // System.out.println(floor(root, 3));
        // System.out.println(floor(root, 9));
        // System.out.println(floor(root, 22));
        // System.out.println();

        System.out.println(validate(root));
        
        Node rooot = Node.Tree(new Integer[]{ 3, 5, 1, 6, 2, 0, 8, 7, 4 });
        System.out.println(validate(rooot));

        
    }
}

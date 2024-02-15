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
    public static Node insert(Node root, int key) {
        if(root == null) return new Node(key);
        if(key != root.val){
            if(key > root.val){
                root.right = insert(root.right, key);
            }
            else{
                root.left = insert(root.left, key);
            }
        }
        return root;

    }

    public static Node inorderPredecessor(Node root){
        if(root == null || root.left == null) return null;
        Node head = root.left;
        while(head.right != null){
            head = head.right;
        }
        return head;
    }

    public static Node delete(Node root, int key){
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            Node predecessor = inorderPredecessor(root);
            root.val = predecessor.val;
            delete(root.left, predecessor.val);
            return root;
        }
        else if(key > root.val){
            root.right = delete(root.right, key);
        }
        else{
            root.left = delete(root.left, key);
        }
        return root;
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

        // System.out.println(validate(root));
        
        // Node rooot = Node.Tree(new Integer[]{ 3, 5, 1, 6, 2, 0, 8, 7, 4 });
        // System.out.println(validate(rooot));

        root = insert(root, 11);
        System.out.println(Node.inOrder(root));
        root = delete(root, 8);
        System.out.println(Node.inOrder(root));

        
    }
}

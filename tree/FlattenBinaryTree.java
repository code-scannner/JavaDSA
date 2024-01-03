package tree;

import java.util.Stack;

public class FlattenBinaryTree {
    public static Node[] UsingTwoPointer(Node root) {
        if(root == null) return new Node[]{null, null};
        if(root.left == null && root.right == null) return new Node[]{root, root};

        Node[] left = UsingTwoPointer(root.left);
        Node[] right = UsingTwoPointer(root.right);
        
        if(root.right == null){
            root.left = null;
            root.right = left[0];
            return new Node[]{root, left[1]};
        }
        if(root.left == null){
            return new Node[]{root, right[1]};
        }

        root.right = left[0];
        left[1].right = right[0];
        root.left = null;

        return new Node[]{root, right[1]};
    }

    public static void usingIteration(Node root) {
        while (root != null) {
            if(root.left != null){
                Node rightmost = root.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void usingStack(Node root) {
        
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.empty()) {
            Node curr = stk.pop();
            if(curr.right != null) stk.push(curr.right);
            if(curr.left != null) stk.push(curr.left);

            curr.left = null;
            if(!stk.empty()){
                curr.right = stk.peek();
            }
        }

    }
    public static void main(String[] args) {
        Integer tree[] = { 1, 2, 7, 3, 4, null, null, null, null, 5, 6 };
        Node root = Node.Tree(tree);
        Node rooot = Node.Tree(new Integer[]{
            1,2,5,3,4,null,6,null,null,null,null,7
        });
        // root = UsingTwoPointer(root)[0];
        // rooot = UsingTwoPointer(rooot)[0];

        // usingIteration(root);
        // usingIteration(rooot);
        
        usingStack(root);
        usingStack(rooot);

        System.out.println(Node.BFStraversal(root));
        System.out.println(Node.BFStraversal(rooot));

    }
}

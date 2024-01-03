package tree;

import java.util.*;

// helpful in time complexity nearly O(n) and constant space O(1)

public class MorrisTraversal {


    public static List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                Node rightmost = curr.left;
                while (rightmost.right != null && rightmost.right != curr) {
                    rightmost = rightmost.right;
                }
                if (rightmost.right == null) {
                    rightmost.right = curr;
                    curr = curr.left;
                } else {
                    rightmost.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                Node rightmost = curr.left;
                while (rightmost.right != null && rightmost.right != curr) {
                    rightmost = rightmost.right;
                }
                if (rightmost.right == null) {
                    rightmost.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                } else {
                    rightmost.right = null;
                    curr = curr.right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer tree[] = { 1, 2, 7, 3, 4, null, null, null, null, 5, 6 };
        Node root = Node.Tree(tree);

        System.out.println(inorder(root));
        System.out.println(Node.inOrder(root));
        System.out.println();

        System.out.println(preorder(root));
        System.out.println(Node.preOrder(root));
        System.out.println();
    }
}

package linkedlist;

import java.util.*;

public class SortedListToBinaryTree {
    public static TreeNode toBinaryTree(Node root) {
        if (root == null)
            return null;
        if (root.next == null)
            return new TreeNode(root.val);

        Node prev = null, curr = root, end = root;
        while (end.next != null && end.next.next != null) {
            prev = curr;
            curr = curr.next;
            end = end.next.next;
        }

        TreeNode right = toBinaryTree(curr.next);
        TreeNode left = null;
        if (prev != null) {
            prev.next = null;
            left = toBinaryTree(root);
        }
        return new TreeNode(curr.val, left, right);
    }

    public static void main(String[] args) {
        Node list = Node.LList(new int[] {
                -10, -3, 0, 5, 9
        });

        System.out.println(TreeNode.inOrder(toBinaryTree(list)));

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static void _inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            _inOrder(root.left, list);
            list.add(root.val);
            _inOrder(root.right, list);
        }
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        _inOrder(root, result);
        return result;
    }
}
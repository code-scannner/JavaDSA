package tree;

import java.util.*;

public class Node {
    Node left;
    Node right;
    int val;

    Node(int data) {
        left = null;
        right = null;
        val = data;
    }

    public static Node Tree(Integer arr[]) {
        int n = arr.length;
        if (n == 0)
            return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.offer(root);
        for (int i = 1; i < n; i += 2) {
            if (arr[i] != null) {
                Node left = new Node(arr[i]);
                q.peek().left = left;
                q.offer(left);
            }
            if (i + 1 < n && arr[i + 1] != null) {
                Node right = new Node(arr[i + 1]);
                q.peek().right = right;
                q.offer(right);
            }

            q.poll();
        }
        return root;
    }

    private static void _inOrder(Node root, List<Integer> list) {
        if (root != null) {
            _inOrder(root.left, list);
            list.add(root.val);
            _inOrder(root.right, list);
        }
    }

    public static List<Integer> inOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        _inOrder(root, result);
        return result;
    }

    private static void _preOrder(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            _preOrder(root.left, list);
            _preOrder(root.right, list);
        }
    }

    public static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        _preOrder(root, result);
        return result;
    }

    private static void _postOrder(Node root, List<Integer> list) {
        if (root != null) {
            _postOrder(root.left, list);
            _postOrder(root.right, list);
            list.add(root.val);
        }
    }

    public static List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        _postOrder(root, result);
        return result;
    }

    public static List<Integer> BFS(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            list.add(node.val);
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        return list;
    }

}

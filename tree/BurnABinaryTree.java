package tree;

import java.util.*;

// longest path from that node

public class BurnABinaryTree {
    public static int minTime(Node root, int from) {
        Map<Node, Node> map = new HashMap<>();
        // <child, parent>
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        map.put(root, null);
        Node targetNode = null;
        while (!q.isEmpty()) {
            Node parent = q.poll();
            if (parent.val == from) {
                targetNode = parent;
            }
            if (parent.left != null) {
                map.put(parent.left, parent);
                q.offer(parent.left);
            }
            if (parent.right != null) {
                map.put(parent.right, parent);
                q.offer(parent.right);
            }
        }

        int time = 0;
        if (targetNode == null)
            return time;

        Set<Node> visited = new HashSet<>();
        visited.add(targetNode);
        q.offer(targetNode);
        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                Node node = q.poll();
                Node parent = map.get(node);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }
                size--;
            }
            time++;
        }

        return time - 1;
    }

    static int ans = 0;

    public static int dfs(Node root, int from) {
        if (root == null)
            return 0;

        int left = dfs(root.left, from);
        int right = dfs(root.right, from);

        if (root.val == from) {
            ans = Math.max(ans, Math.max(right, left));
            return -1;
        } else if (left >= 0 && right >= 0) {
            return 1 + Math.max(left, right);
        } else {
            ans = Math.max(ans, Math.abs(left) + Math.abs(right));
            return Math.min(left, right) - 1;
        }
    }

    public static int optimal(Node root, int from) {
        dfs(root, from);
        return ans;
    }

    public static void main(String[] args) {
        // Node root = Node.Tree(new Integer[] {
        // 1, 2, 3, 4, null, 5, 6, null, 7
        // });
        Node root = Node.Tree(new Integer[] {
                1, 5, 3, null, 4, 10, 6, 9, 2, null, null, 8, 7
        });
        System.out.println(optimal(root, 2));
    }
}

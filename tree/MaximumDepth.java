package tree;

import java.util.*;

public class MaximumDepth {
    public static int maxDepth(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int maxWidth(Node root) {
        int result = 1;

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int left = q.peek().second;
            int right = left;
            while (size > 0) {
                Pair<Node, Integer> pair = q.poll();
                Node node = pair.first;
                int index = pair.second;
                if (size == 1)
                    right = index;
                if (node.left != null)
                    q.offer(new Pair<>(node.left, 2 * index + 1));
                if (node.right != null)
                    q.offer(new Pair<>(node.right, 2 * index + 2));
                size--;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;

    }

    public static void main(String[] args) {
        Node root = Node.Tree(new Integer[] {
                1, 2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, null,9
        });
        Node root2 = Node.Tree(new Integer[] {
                1
        });
        System.out.println(maxDepth(root));
        System.out.println(maxDepth(root2));
        System.out.println();

        System.out.println(maxWidth(root));
        System.out.println(maxWidth(root2));
    }
}

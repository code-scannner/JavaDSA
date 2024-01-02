package tree;

import java.util.*;

public class ViewOfTree {

    public static List<Integer> topView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int i = size;
            while (i > 0) {
                Pair<Node, Integer> pair = q.poll();
                Node node = pair.first;
                int x = pair.second;
                // end units
                if (i == size || i == 1) {
                    map.putIfAbsent(x, node.val);
                }

                if (node.left != null)
                    q.offer(new Pair<>(node.left, x - 1));
                if (node.right != null)
                    q.offer(new Pair<>(node.right, x + 1));

                i--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static List<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int i = size;
            while (i > 0) {
                Pair<Node, Integer> pair = q.poll();
                Node node = pair.first;
                int x = pair.second;
                // end units
                map.put(x, node.val);

                if (node.left != null)
                    q.offer(new Pair<>(node.left, x - 1));
                if (node.right != null)
                    q.offer(new Pair<>(node.right, x + 1));

                i--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static List<List<Integer>> leftRightView(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int i = size;
            leftView.add(q.peek().val);
            while (i > 0) {
                Node node = q.poll();
                if (i == 1) {
                    rightView.add(node.val);
                }
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

                i--;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(leftView);
        result.add(rightView);
        return result;
    }

    public static void main(String[] args) {
        Integer tree[] = { 1, 2, 3, 4, 5, null, 7, null, null, 6 };
        Node root = Node.Tree(tree);

        Node rooot = Node.Tree(new Integer[] {
                1, 2, 3, 4, 5, 6, 7, null, null, 13, 10, null, null, null, null, 8, null, null, 11, 9, null, null, 12
        });

        System.out.println(topView(root));
        System.out.println(topView(rooot));
        System.out.println();

        System.out.println(bottomView(root));
        System.out.println(bottomView(rooot));
        System.out.println();

        System.out.println(leftRightView(root));
        System.out.println(leftRightView(rooot));
        System.out.println();
    }
}

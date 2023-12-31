package tree;

import java.util.*;

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }

    @Override
    public String toString() {
        return "{ " + first.toString() + ", " + second.toString() + " }";
    }
}

class Triplet {
    Node node;
    int x, y;

    Triplet(Node _node, int _x, int _y) {
        node = _node;
        x = _x;
        y = _y;
    }

    @Override
    public String toString() {
        return "{ " + node.toString() + ", " + x + ", " + y + " }";
    }
}

public class Node {
    Node left;
    Node right;
    int val;

    Node(int data) {
        left = null;
        right = null;
        val = data;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
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

    public static List<Integer> BFStraversal(Node root) {
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

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        int x = leftIndent(root, 0);

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, x));

        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.first;
            int vertical = pair.second;
            while (ans.size() <= vertical)
                ans.add(new ArrayList<>());
            ans.get(vertical).add(node.val);
            if (node.left != null)
                q.offer(new Pair<>(node.left, vertical - 1));
            if (node.right != null)
                q.offer(new Pair<>(node.right, vertical + 1));
        }

        return ans;
    }

    public static List<List<Integer>> verticalUsingPQ(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triplet> q = new LinkedList<>();


        q.offer(new Triplet(root, 0, 0));
        while (!q.isEmpty()) {
            Triplet t = q.poll();
            Node node = t.node;
            int x = t.x;
            int y = t.y;
            if(!map.containsKey(y)){
                map.put(y,new TreeMap<>());
            }
            if(!map.get(y).containsKey(x)){
                map.get(y).put(x, new PriorityQueue<>());
            }

            map.get(y).get(x).offer(node.val);

            if(node.left != null){
                q.offer(new Triplet(node.left, x + 1, y - 1));
            }
            
            if(node.right != null){
                q.offer(new Triplet(node.right, x + 1, y + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> vmap : map.values()){
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : vmap.values()) {
                for (Integer nodeval : nodes) {
                    list.add(nodeval);
                }
            }
            result.add(list);
        }
        return result;
    }

    private static int leftIndent(Node root, int idx) {
        if (root == null)
            return idx - 1;
        int left = leftIndent(root.left, idx + 1);
        int right = leftIndent(root.right, idx - 1);

        return Math.max(left, right);
    }
}

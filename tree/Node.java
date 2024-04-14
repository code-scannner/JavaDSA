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
    public Node left;
    public Node right;
    public int val;

    Node(int data) {
        left = null;
        right = null;
        val = data;
    }
    Node(int data, Node _l, Node _r) {
        left = _l;
        right = _r;
        val = data;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static String Serialize(Node root) {

        if(root == null) return "";
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        StringBuilder str = new StringBuilder();
        str.append(root.val);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left == null){
                str.append(" #");
            }
            else {
                str.append(" ");
                str.append(node.left.val);
                q.offer(node.left);
            }
            if(node.right == null){
                str.append(" #");
            }
            else {
                str.append(" ");
                str.append(node.right.val);
                q.offer(node.right);
            }
        }

        return str.toString();
    }

    public static Node deSerialize(String data) {

        if(data.length() == 0) return null;
        String nodes [] = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        q.offer(root);
        int j = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(nodes[j].charAt(0) != '#'){
                node.left = new Node(Integer.parseInt(nodes[j]));
                q.offer(node.left);
            }
            j++;
            if(nodes[j].charAt(0) != '#'){
                node.right = new Node(Integer.parseInt(nodes[j]));
                q.offer(node.right);
            }
            j++;
        }
        return root;
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

    public static List<List<Integer>> BFStraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                Node node = q.poll();
                list.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                size--;
            }
            result.add(list);
        }
        return result;
    }
    public static void traverse(PriorityQueue<int []> pq , Node root , int x, int y){
        if(root == null) return;
        pq.offer(new int[]{x,y, root.val});
        traverse(pq, root.left, x - 1, y + 1);
        traverse(pq, root.right, x + 1, y + 1);
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int prevx = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        traverse(pq, root, 0,0);
        while(!pq.isEmpty()){
            int [] node = pq.poll();
            int x = node[0], val = node[2];
            if(x != prevx){
                result.add(new ArrayList<>());
                prevx = x;
            }
            result.get(result.size() - 1).add(val);
        }

        return result;
    }
    
}

package tree;

import java.util.*;

class Pair {
    Node node;
    Integer order;

    Pair(Node n, Integer o) {
        node = n;
        order = o;
    }
}

public class IterativeTraversal {
    public static List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();

            list.add(node.val);
            if (node.right != null)
                stk.push(node.right);
            if (node.left != null)
                stk.push(node.left);
        }
        return list;
    }

    public static List<Integer> inOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.empty()) {
            if (stk.peek() == null) {
                stk.pop();
                if (!stk.empty()) {
                    list.add(stk.peek().val);
                    stk.push(stk.pop().right);
                }
            } else {
                stk.push(stk.peek().left);
            }

            // // Another way
            // while(stk.peek().left != null) stk.push(stk.peek().left);
            // list.add(stk.pop().val);
            // if(!stk.empty()){
            // list.add(stk.peek().val);
            // stk.push(stk.pop().right);
            // }
        }
        return list;
    }

    public static List<Integer> postOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();

        stk1.push(root);
        while (!stk1.empty()) {
            Node node = stk1.pop();
            if (node == null) {
                list.add(stk2.pop().val);
            } else if (node.right == null && node.left == null) {
                list.add(node.val);
            } else {
                stk1.push(null);
                if (node.right != null)
                    stk1.push(node.right);
                if (node.left != null)
                    stk1.push(node.left);
                stk2.push(node);
            }
        }

        return list;

    }

    public static List<Integer> postOrder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        stk.push(root);

        Node curr = root.left;
        while (!stk.empty()) {
            if (curr != null) {
                stk.push(curr);
                curr = curr.left;
            } else {
                Node top = stk.peek();
                if (top.right == null) {
                    list.add(stk.pop().val);
                    while (!stk.empty() && stk.peek().right == top) {
                        top = stk.pop();
                        list.add(top.val);
                    }
                } else {
                    curr = top.right;
                }
            }
        }

        // // Another Way
        // while (!stk.empty()) {
        // Node node = stk.peek();
        // if(node == null){
        // stk.pop();
        // if(!stk.empty() && stk.peek() != null){
        // list.add(stk.pop().val);
        // }
        // }
        // else{
        // stk.push(null);
        // stk.push(node.right);
        // stk.push(node.left);
        // }
        // }

        return list;

    }

    public static List<List<Integer>> allTraversals(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, 1));

        while (!stk.empty()) {
            Pair pair = stk.pop();
            int value = pair.node.val;
            if (pair.order == 1) {
                pre.add(value);
                pair.order++;
                stk.push(pair);
                if (pair.node.left != null)
                    stk.push(new Pair(pair.node.left, 1));
            } else if (pair.order == 2) {
                in.add(value);
                pair.order++;
                stk.push(pair);
                if (pair.node.right != null)
                    stk.push(new Pair(pair.node.right, 1));
            } else {
                post.add(value);
            }
        }

        result.add(pre);
        result.add(in);
        result.add(post);
        return result;

    }

    public static List<Integer> zigZag(Node root) {
        List<Integer> ans = new ArrayList<>();

        Deque<Node> dq = new LinkedList<>();
        boolean mode = true;
        dq.offer(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size > 0) {
                if (mode) {
                    Node node = dq.pollFirst();
                    ans.add(node.val);
                    if (node.left != null)
                        dq.offerLast(node.left);
                    if (node.right != null)
                        dq.offerLast(node.right);
                } else {
                    Node node = dq.pollLast();
                    ans.add(node.val);
                    if (node.right != null)
                        dq.offerFirst(node.right);
                    if (node.left != null)
                        dq.offerFirst(node.left);
                }
                size--;
            }
            mode = !mode;
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer tree[] = { 1, 2, 7, 3, 4, null, null, null, null, 5, 6 };
        Node root = Node.Tree(tree);

        System.out.println(preOrder(root));
        System.out.println(Node.preOrder(root));
        System.out.println();

        System.out.println(inOrder(root));
        System.out.println(Node.inOrder(root));
        System.out.println();

        System.out.println(postOrder(root));
        // System.out.println(postOrder2(root));
        System.out.println(Node.postOrder(root));
        System.out.println();

        // System.out.println(allTraversals(root));

        System.out.println(zigZag(root));

    }
}

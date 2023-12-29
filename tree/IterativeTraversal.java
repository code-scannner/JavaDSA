package tree;

import java.util.*;

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
        while (!stk.empty()) {
            Node node = stk.peek();
            if(node == null){
                stk.pop();
                if(!stk.empty() && stk.peek() != null){
                    list.add(stk.pop().val);
                }
            }
            else{
                stk.push(null);
                stk.push(node.right);
                stk.push(node.left);
            }
        }

        return list;

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
        System.out.println(postOrder2(root));
        System.out.println(Node.postOrder(root));
        System.out.println();
    }
}

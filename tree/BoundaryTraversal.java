package tree;

import java.util.*;

public class BoundaryTraversal {
    public static void leftBoundary(List<Integer> list, Node root) {

        if (root.left != null || root.right != null) {
            list.add(root.val);
            if (root.left == null)
                leftBoundary(list, root.right);
            else
                leftBoundary(list, root.left);
        }
    }

    public static void rightBoundary(List<Integer> list, Node root) {

        if (root.left != null || root.right != null) {
            if (root.right == null)
                rightBoundary(list, root.left);
            else
                rightBoundary(list, root.right);
            list.add(root.val);
        }
    }

    public static void leafNodes(List<Integer> list, Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            } else {
                leafNodes(list, root.left);
                leafNodes(list, root.right);
            }
        }
    }

    public static List<Integer> boundary(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        list.add(root.val);
        if(root.left != null)
            leftBoundary(list, root.left);
        leafNodes(list, root.left);
        leafNodes(list, root.right);
        if(root.right != null)
            rightBoundary(list, root.right);
        return list;
    }

    public static void main(String[] args) {
        Node tree = Node.Tree(new Integer[] {
                1, 2, 7, 3, null, null, 8, null, 4, 9, null, 5, 6, 10, 11
        });

        Node tree2 = Node.Tree(new Integer[] {
                1,2
        });

        System.out.println(boundary(tree));
        System.out.println(boundary(tree2));
    }
}

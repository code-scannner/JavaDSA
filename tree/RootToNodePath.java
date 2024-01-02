package tree;

import java.util.*;

public class RootToNodePath {

    private static boolean _path(List<Integer> result, Node root, int target) {
        if (root == null)
            return false;

        if (root.val == target || _path(result, root.left, target) || _path(result, root.right, target)) {
            result.add(root.val);
            return true;
        }

        return false;
    }

    public static List<Integer> pathToTarget(Node root, int target) {
        List<Integer> list = new ArrayList<>();
        _path(list, root, target);
        Collections.reverse(list);
        return list;
    }

    public static Node lowestCommonAncestor(Node root, int a, int b) {
        if(root == null) return null;
        
        if(root.val == a || root.val == b) return root;

        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);

        if(left == null) return right;
        if(right == null) return left;

        return root;

    }
    public static void main(String[] args) {
        Node root = Node.Tree(new Integer[] {
                1, 2, 3, 4, 5, null, null, null, null, 6, 7
        });
        System.out.println(pathToTarget(root, 7));
        System.out.println();

        System.out.println(lowestCommonAncestor(root, 5, 4));

    }
}

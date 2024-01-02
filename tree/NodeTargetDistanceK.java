package tree;

import java.util.*;

public class NodeTargetDistanceK {

    public static List<Node> NodesAtDistanceKfromTarget(Node root, int target, int k) {

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        map.put(root, null);
        Node targetNode = null;
        while (!q.isEmpty()) {
            Node parent = q.poll();
            if (parent.val == target) {
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
        
        if(targetNode == null) return new ArrayList<>();

        q.clear();
        q.offer(targetNode);

        Set<Node> visited = new HashSet<>();
        visited.add(targetNode);

        int dis = 0;
        while(!q.isEmpty() && dis < k){
            int size = q.size();
            while (size > 0) {
                Node node = q.poll();
                Node parent = map.get(node);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);
                }
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.offer(node.right);
                }
                size--;
            }
            dis++;
        }
        
        return new ArrayList<>(q);

    }

    public static void main(String[] args) {
        Integer tree[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        Node root = Node.Tree(tree);

        System.out.println(NodesAtDistanceKfromTarget(root, 5, 1));

    }
}

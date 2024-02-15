package tree;

public class LowestCommonAncestor {
    public static Node lowestCommonAncestor(Node root, int p, int q) {
        int lower = Math.min(p, q);
        int upper = Math.max(p, q);
        while(!(root.val < lower ^ root.val < upper)){
            if(root.val == lower || root.val == upper) return root;
            if(lower > root.val){
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node tree = Node.Tree(new Integer[] {
            6,2,8,0,4,7,9,null,null,3,5
        });

        System.out.println(lowestCommonAncestor(tree, 2, 8));
    }
}

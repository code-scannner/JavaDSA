package graph;

public class DisjointSetUnion {
    public static void main(String[] args) {
        DSU d = new DSU(8);
        d.union(1, 2);
        d.union(2, 3);
        d.union(4, 5);
        d.union(6, 7);
        d.union(5, 6);
        System.out.println(d.findParent(3) == d.findParent(7));
        System.out.println(d.findParent(4) == d.findParent(7));

    }
}

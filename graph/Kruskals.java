package graph;

import java.util.*;

// Time Complexity O(E logV) 
// Extra Space Complexity O(V)
public class Kruskals {
    // edge = {src, dest, wgt} // undirected edge
    public static List<int[]> mst(int edges[][], int n) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(edges, (a,b)->a[2] - b[2]);
        DSU set = new DSU(n);
        for(int [] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            if(set.findParent(src) != set.findParent(dest)){
                set.union(src, dest);
                result.add(new int[]{src, dest});
            }
        }

        return result;
    }

    public static int mstWeight(int edges[][], int n) {
        Arrays.sort(edges, (a,b)->a[2] - b[2]);
        DSU set = new DSU(n);
        int sum = 0;
        for(int [] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            int wgt = edge[2];
            if(set.findParent(src) != set.findParent(dest)){
                set.union(src, dest);
                sum += wgt;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int edges[][] = {
                { 0, 1, 2 },
                { 0, 2, 1 },
                { 2, 1, 1 },
                { 2, 4, 2 },
                { 2, 3, 2 },
                { 4, 3, 1 }
        };
        List<int[]> mstEdges = mst(edges, 5);
        for (int arr[] : mstEdges)
            System.out.println(Arrays.toString(arr));

        System.out.println(mstWeight(edges, 5));
    }
}
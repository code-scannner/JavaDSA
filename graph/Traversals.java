package graph;

import java.util.*;

public class Traversals {
    public static void main(String[] args) {
        int edgeList[][] = {
                { 1, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 },
                { 2, 1 }, { 3, 1 }, { 4, 2 }, { 4, 3 }
        };
        ArrayList<Edge> graph[] = Graph.createGraph(edgeList, 5);

        System.out.println(Graph.bfs(graph));
    }
}

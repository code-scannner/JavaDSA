package graph;
import java.util.*;

public class EventualSafeStates {
    public static boolean _dfs(int node, List<List<Integer>> adj, int visited[]) {
        for (int i : adj.get(node)) {
            if (visited[i] == 2) {
                return true;
            }
            if (visited[i] == 0) {
                visited[i] = 2;
                boolean cycle = _dfs(i, adj, visited);
                if(cycle) return true;
                visited[i] = 1;
            }
        }

        return false;
    }

    public static List<Integer> eventualStates(List<List<Integer>> adj) {
        int V = adj.size();
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                visited[i] = 2;
                boolean cycle = _dfs(i, adj, visited);
                visited[i] = cycle ? 2 : 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<V; i++) {
            if(visited[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
    public static List<Integer> usingBfsTopoSort(List<List<Integer>> adj) {
        int n = adj.size();
        List<List<Integer>> a =  new ArrayList<>();
        for(int i = 0; i<n; i++) a.add(new ArrayList<>());

        for(int i = 0; i<n; i++){
            for(int node : adj.get(i)){
                a.get(node).add(i);
            }
        }
        List<Integer> result =  TopoSort.bfs(a);
        result.sort(null);
        return result;
    }

    public static void main(String[] args) {
        int [][] adjMat = {
            {1,2},
            {2,3},
            {5},
            {0},
            {5},
            {},
            {},
        };
        List<List<Integer>> adjlist = Graph.arrayToAdjList(adjMat, adjMat.length);
        System.out.println(eventualStates(adjlist));
        System.out.println(usingBfsTopoSort(adjlist));

    }
}

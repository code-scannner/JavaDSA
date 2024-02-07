package graph;

public class CountConnectedComponents {

    public static int count(int[][] edges, int V) {
        int dSet[] = DisjointSet.createSet(edges, V);
        int cnt = 0;
        for(int i = 0; i<V; i++){
            if(dSet[i] < 0){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int edges[][] = new int[][] {
                { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 }
        };
        /*
         * 0----2
         * |    |
         * 5----4 3 1----6
         */
        System.out.println(count(edges, 7));
    }
}

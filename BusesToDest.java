import java.util.*;

public class BusesToDest {
    public static int numBusesToDestination(int[][] routes, int src, int tar) {

        boolean vis_rout[] = new boolean[routes.length];
        Set<Integer> vis_stops = new HashSet<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<int[]> q = new LinkedList<int[]>();

        int bus = 0;
        for (int[] route : routes) {
            for (int stop : route) {
                if (map.containsKey(stop)) {
                    map.get(stop).add(bus);
                } else {
                    map.put(stop, new ArrayList<Integer>(Arrays.asList(bus)));
                }
            }
            bus++;
        }

        q.add(new int[] { src, 0 });
        while (!q.isEmpty()) {
            int[] stop = q.remove();
            if(stop[0] == tar) return stop[1];
            vis_stops.add(stop[0]);
            List<Integer> buses = map.get(stop[0]);
            for (int b : buses) {
                if(!vis_rout[b]){
                    for(int bustop : routes[b]){
                        if(bustop == tar) return stop[1] + 1;
                        if(!vis_stops.contains(bustop)){
                            q.add(new int[]{bustop, stop[1] + 1});
                        }
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[][] routes = new int[][] { { 1, 2, 7 }, { 3, 6, 7 } };
        int source = 1;
        int target = 6;

        int result = numBusesToDestination(routes, source, target);
        System.out.println(result);
    }
}
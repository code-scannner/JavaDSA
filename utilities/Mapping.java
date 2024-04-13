package utilities;
import java.util.*;

public class Mapping {
    public static void main(String[] args) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,2);
        map.put(2,6);
        map.put(1,6);
        
        System.out.println(map);

        // System.out.println(map.entrySet());
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        //     new Comparator<Map.Entry<Integer, Integer>>() {
        //         @Override
        //         public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
        //             if(a.getValue() == b.getValue()){
        //                 return a.getKey() - b.getKey();
        //             }
        //             return b.getValue() - a.getValue();
        //         }
        //     }
        // );

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     pq.offer(entry);
        // }
        // pq.clear();
        // map.put(5,7);
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     pq.offer(entry);
        // }

        // while(!pq.isEmpty()){
        //     System.out.println(pq.poll().getKey());
        // }

        // System.out.println(pq);


        // putting value
        // map.put(65, 2);
        // map.put(70, 1);

        // traversing keys and values
        // for (int key : map.keySet()) {
        //     System.out.println(key + " " + map.get(key));
        // }
        
        // return list of values
        // System.out.println(map.get(56));
               
        
    }
}

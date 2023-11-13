import java.util.*;

public class Mapping {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        // putting value
        map.put(65, 2);
        map.put(70, 1);

        // traversing keys and values
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        
        // return list of values
        System.out.println(map.values());
        
    }
}

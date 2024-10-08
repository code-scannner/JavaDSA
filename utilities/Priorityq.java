package utilities;

import java.util.*;

class Food {
    String name;
    int rating;

    Food(String n, int r) {
        name = n;
        rating = r;
    }

    @Override
    public String toString() {
        return name + " " + rating;
    }
}

public class Priorityq {

    public static void main(String[] args) {

        PriorityQueue<Food> pq = new PriorityQueue<>(
                new Comparator<Food>() {
                    @Override
                    public int compare(Food f1, Food f2) {
                        if (f1.rating < f2.rating)
                            return 1;
                        else if (f1.rating == f2.rating && f1.name.compareTo(f2.name) > 0)
                            return 1;
                        return -1;
                    }
                });
        Food fd = new Food("miso", 2);
        pq.add(fd);
        
        pq.add(new Food("sushi", 8));
        pq.add(new Food("ramen", 14));
        pq.add(new Food("kimchi",9));
        pq.add(new Food("bulgogi", 7));
        
        // the values changed at runtime in classes inside priorityqueue
        // does not rearrange the priority queue
        fd.rating = 23;

        System.out.println(pq);


        // Iterator<Food> it = pq.iterator();
        // while(it.hasNext()){
        // System.out.println(it.next());
        // }
        // pq.remove(new Food("dfd",45));

        // Creating max heap
        // PriorityQueue<Integer> pQueue
        // = new PriorityQueue<Integer>(Collections.reverseOrder());

    }
}

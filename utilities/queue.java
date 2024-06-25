package utilities;
import java.util.*;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(4);
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(3);
        dq.offer(4);
        dq.offer(5);
        dq.removeFirst();
        System.out.println(dq.peekLast());
        System.out.println(dq.pollLast());
        System.out.println(q.poll());
        System.out.println(dq);
    }
}

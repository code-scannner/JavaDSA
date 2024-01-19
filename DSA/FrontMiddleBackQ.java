package DSA;

import java.util.*;

class FrontMiddleBackQueue {
    Deque<Integer> front, back;

    public FrontMiddleBackQueue() {
        front = new LinkedList<>();
        back = new LinkedList<>();
    }

    public void equilibrium() {
        // making equilibrium

        while (front.size() - back.size() > 1) {
            back.offerFirst(front.pollLast());
        }
        while (back.size() > front.size()) {
            front.offerLast(back.pollFirst());
        }
    }

    public void pushFront(int val) {
        front.offerFirst(val);
    }

    public void pushMiddle(int val) {

        equilibrium();
        if(front.size() > back.size()) {
            back.offerFirst(front.pollLast());
            front.offerLast(val);
        }
        else front.offerLast(val);
    }

    public void pushBack(int val) {
        back.offerLast(val);
    }

    public int popFront() {
        if (front.size() == 0) {
            if (back.size() == 0)
                return -1;
            return back.pollFirst();
        }
        return front.pollFirst();
    }

    public int popMiddle() {

        equilibrium();

        if (front.size() == 0)
            return -1;
        return front.pollLast();

    }

    public int popBack() {
        if (back.size() == 0) {
            if (front.size() == 0)
                return -1;
            return front.pollLast();
        }
        return back.pollLast();
    }
}

public class FrontMiddleBackQ {
    public static void main(String[] args) {
        FrontMiddleBackQueue pq = new FrontMiddleBackQueue();
        pq.pushFront(1);
        pq.pushBack(2);
        pq.pushMiddle(3);
        pq.pushMiddle(4);
        System.out.println(pq.front);
        System.out.println(pq.back);
        System.out.println(pq.popFront());
        System.out.println(pq.popMiddle());
        System.out.println(pq.popMiddle());
        System.out.println(pq.popBack());
        System.out.println(pq.popFront());
    }
}
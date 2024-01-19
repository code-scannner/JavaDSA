package DSA;

class MyCircularDeque {
    int q[];
    int f = 0, l = 0;
    int size, fill = 0;
    public MyCircularDeque(int k) {
        q = new int[k];
        size = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;

        q[f] = value;
        f = (f - 1 + size)%size;
        fill++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;

        l = (l + 1) %size;
        q[l] = value;
        fill++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        f = (f + 1)%size;
        fill--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        l = (l - 1 + size) % size;
        fill--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : q[(f + 1)%size];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : q[l];
    }
    
    public boolean isEmpty() {
        return fill == 0;
    }
    
    public boolean isFull() {
        return fill == q.length;
    }
}

public class CircularDequeue {
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertFront(1));
        System.out.println(deque.insertFront(2));
        System.out.println(deque.insertLast(3));
        System.out.println(deque.isFull());
    }
}

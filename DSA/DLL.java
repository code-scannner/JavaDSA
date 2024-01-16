package DSA;

public class DLL {
    public DLLNode front;
    public DLLNode rear;

    public DLL() {
        front = null;
        rear = null;
    }

    public DLLNode removeFront() {
        DLLNode removed = null;
        if (front != null) {
            removed = front;
            if (front.next != null) {
                front.next.prev = null;
                front = front.next;
            } else {
                front = null;
            }
        }

        removed.next = null;
        removed.prev = null;

        return removed;
    }

    public DLLNode extractNode(DLLNode node) {
        if (node != null) {
            if (node.prev == null) {
                front = node.next;
                node.next = null;
                return node;
            } else if (node.next == null) {
                node.prev.next = null;
                rear = node.prev;
                return node;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                return node;
            }
        }

        return null;
    }

    public void insertEnd(DLLNode node) {
        if (rear == null) {
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        node.prev = rear;
        rear = node;
    }

    public void insertEnd(int num) {
        DLLNode node = new DLLNode(num);
        insertEnd(node);
    }

    public void print() {
        DLLNode curr = front;
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
        System.out.println();
    }
}

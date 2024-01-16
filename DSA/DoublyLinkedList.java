package DSA;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertEnd(6);
        list.insertEnd(7);
        list.print();
        // list.extractNode(list.front);
        // list.extractNode(list.rear);
        DLLNode extracted = list.extractNode(list.front.next);
        list.insertEnd(extracted);
        list.removeFront();

        // System.out.println(list.front);
        list.print();
    }
}

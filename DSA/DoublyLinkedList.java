package DSA;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.offerFirst(1);
        list.offerLast(2);
        list.offerLast(3);
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list.pollFirst());
        System.out.println(list);

    }
}
